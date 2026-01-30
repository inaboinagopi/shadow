package com.shadowapp.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;

@SuppressWarnings("unchecked")
@Component
public class EntityManagerUtil {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(EntityManagerUtil.class);

	@PersistenceContext
	public EntityManager entityManager;

	@Autowired
	ErrorMessageUtil errorMessageUtil;

	private StringBuffer vat = null;

	public List<Tuple> getQueryResult(String qry) {
		try {
			return entityManager.createNativeQuery(qry, Tuple.class).getResultList();

		} catch (Exception e) {
			if (entityManager != null) {
				entityManager.close(); // Close EntityManager
			}
			return null;
		}
	}

	@Transactional
	public void clearEntityManager() {
		// Clear the persistence context
		entityManager.clear();

		// Unwrap the Hibernate session
		Session session = entityManager.unwrap(Session.class);

		// Hibernate 6.x: Instead of using `disconnect()`, you can use `close()`
		// This closes the session and releases any associated resources
		if (session.isOpen()) {
			session.close();
		}
	}

	public ResponseEntity<?> getQueryResultEntity(String qry) {
		try {

			List<Tuple> result = entityManager.createNativeQuery(qry, Tuple.class).getResultList();

			LinkedList<Map<String, Object>> formattedRows = new LinkedList<>();

			if (result != null && !result.isEmpty()) {

				result.forEach(row -> {
					LinkedHashMap<String, Object> formattedRow = new LinkedHashMap<>();

					row.getElements().forEach(column -> {
						String columnName = column.getAlias();

						Object columnValue = row.get(column);

						if (columnValue instanceof Date) {

							columnValue = columnValue.toString().equals("00:00:00") ? columnValue
									: DU.format(DU.parse(columnValue.toString().replace(".0", ""), "yyyy-MM-dd"),
											"yyyy-MM-dd");
						}

						formattedRow.put(columnName.trim(), columnValue == null ? "" : columnValue.toString().trim());
					});

					formattedRows.add(formattedRow);
				});
				return ResponseEntity.ok(new Gson().toJson(formattedRows));
			} else {
				return ResponseEntity.ok(new Gson().toJson("No data found"));
			}
		} catch (Exception e) {
			if (entityManager != null) {
				entityManager.close(); // Close EntityManager
			}
			return ResponseEntity.unprocessableEntity().body(new Gson()
					.toJson(errorMessageUtil.getError(HttpStatus.EXPECTATION_FAILED, e.getLocalizedMessage())));
		}
	}

	public ResponseEntity<?> getQueryResultEntityReport(String qry) {
		try {

			List<Tuple> result = entityManager.createNativeQuery(qry, Tuple.class).getResultList();

			LinkedList<Map<String, Object>> formattedRows = new LinkedList<>();

			if (result != null && !result.isEmpty()) {

				result.forEach(row -> {
					LinkedHashMap<String, Object> formattedRow = new LinkedHashMap<>();

					row.getElements().forEach(column -> {
						String columnName = column.getAlias();

						Object columnValue = row.get(column);

						formattedRow.put(columnName.trim(), columnValue == null ? "" : columnValue.toString().trim());
					});

					formattedRows.add(formattedRow);
				});
				return ResponseEntity.ok(new Gson().toJson(formattedRows));
			} else {
				return ResponseEntity.ok(new Gson().toJson("No data found"));
			}
		} catch (Exception e) {
			if (entityManager != null) {
				entityManager.close(); // Close EntityManager
			}
			return ResponseEntity.unprocessableEntity().body(new Gson()
					.toJson(errorMessageUtil.getError(HttpStatus.EXPECTATION_FAILED, e.getLocalizedMessage())));
		}
	}

	public LinkedList<Map<String, Object>> getQueryResultEntityMap(String qry) {
		try {

			List<Tuple> result = entityManager.createNativeQuery(qry, Tuple.class).getResultList();

			LinkedList<Map<String, Object>> formattedRows = new LinkedList<>();

			if (result != null && !result.isEmpty()) {

				result.forEach(row -> {
					LinkedHashMap<String, Object> formattedRow = new LinkedHashMap<>();

					row.getElements().forEach(column -> {
						String columnName = column.getAlias();

						Object columnValue = row.get(column);

						if (columnValue instanceof Date) {

							columnValue = DU.format(DU.parse(columnValue.toString(), "yyyy-MM-dd"), "yyyy-MM-dd");
						}

						formattedRow.put(columnName.toString().trim(), columnValue.toString().trim());
					});

					formattedRows.add(formattedRow);
				});
			}
			return formattedRows;

		} catch (Exception e) {
			if (entityManager != null) {
				entityManager.close(); // Close EntityManager
			}
			e.printStackTrace();
		}
		return null;
	}

	public String getQueryResultSet(String qry) {
		try {

			// qry = "064c5043-54d2-49ea-abd8-3cacd3307203";
			String sql = "select TOKEN_ID, TOKEN,USER_NAME,CLIENT_ID from oauth_access_token where token_id ='"
					+ extractTokenKey(qry) + "'";

			List<Tuple> result = entityManager.createNativeQuery(sql, Tuple.class).getResultList();

			vat = new StringBuffer("");
			if (result != null && !result.isEmpty()) {

				result.forEach(row -> {

					row.getElements().forEach(column -> {
						String columnName = column.getAlias();
						Object columnValue = row.get(column);
						if (columnName.equalsIgnoreCase("USER_NAME") || columnName.equalsIgnoreCase("CLIENT_ID")) {
							vat.append(
									vat.toString().equalsIgnoreCase("") ? columnValue.toString() : "," + columnValue);
						}

					});

				});
			}

			return vat.toString();

		} catch (Exception e) {
			if (entityManager != null) {
				entityManager.close(); // Close EntityManager
			}
			e.printStackTrace();
		}
		return null;
	}

	protected String extractTokenKey(String value) {
		if (value == null) {
			return null;
		}
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).");
		}

		try {
			byte[] bytes = digest.digest(value.getBytes("UTF-8"));
			return String.format("%032x", new BigInteger(1, bytes));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).");
		}
	}

	public LinkedList<Map<String, Object>> getTupleList(List<Tuple> result) {
		try {

			LinkedList<Map<String, Object>> formattedRows = new LinkedList<>();

			if (result != null && !result.isEmpty()) {

				result.forEach(row -> {
					LinkedHashMap<String, Object> formattedRow = new LinkedHashMap<>();

					row.getElements().forEach(column -> {
						String columnName = column.getAlias();

						Object columnValue = row.get(column);

						if (columnValue instanceof Date) {

							columnValue = DU.format(DU.parse(columnValue.toString(), "yyyy-MM-dd"), "yyyy-MM-dd");
						}

						formattedRow.put(columnName, columnValue == null ? "" : columnValue);
					});

					formattedRows.add(formattedRow);
				});
				return formattedRows;
			}
			return null;
		} catch (Exception e) {
			if (entityManager != null) {
				entityManager.close(); // Close EntityManager
			}
			return null;
		}
	}

	public LinkedList<Map<String, Object>> getTableFormat(List<Map<String, Object>> result) {
		try {
			LinkedList<Map<String, Object>> formattedRows = new LinkedList<>();
			if (result != null && !result.isEmpty()) {
				result.forEach(row -> {
					LinkedHashMap<String, Object> formattedRow = new LinkedHashMap<>();
					row.forEach((key, value) -> {
						if (value instanceof Date) {
							// Format the date if necessary
							value = DU.format(DU.parse(value.toString(), "yyyy-MM-dd"), "yyyy-MM-dd");
						}
						formattedRow.put(key, value == null ? "" : value);
					});
					formattedRows.add(formattedRow);
				});
			}
			return formattedRows;
		} catch (Exception e) {
			// Handle exception if necessary
			return new LinkedList<>();
		}
	}

}
