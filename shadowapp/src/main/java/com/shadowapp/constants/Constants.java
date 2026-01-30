package com.shadowapp.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface Constants {

	public static final String VERSION_PARAM_NAME = "versionId";
	public static final String UPLOADSUCCESFULLY = "SUCCESSFULLY UPLOADED";
	public static final String SUCCESS = "Success";
	public static final String VPCSUCCESS = "SUCCESS";
	public static final String success = "success";
	public static final String FEEDBACK = "feedback";
	public static final String FCM_URL = "https://fcm.googleapis.com/fcm/send";
	public static final String FCM_AUTHORIZATION_KEY = "key=AIzaSyAe_LWDjkU5qwpl69fDIY1Gxvv772eakpc";
	public static final String STUDENT_CONFIRMED_SUCCESSFULLY = "Student Confirmed Successfully.. ";
	public static final String SAVED_SUCCESSFULLY = "Saved Successfully";
	public static final String STUDENT_TRANSFERED = "Student_Transfered";
	public static final String BUSPASS_REFUND_NOTAVAILABLE = "BussPass  Refund Not Available";
	public static final String CAUTION_REFUND_NOTAVAILABLE = "Caution Deposit  Refund Not Available";
	public static final String POCKET_REFUND_NOTAVAILABLE = "Pocket Money  Refund Not Available";
	public static final String AKASH_BOOKS_REFUND_NOTAVAILABLE = "Akash Books Refund Not Available";
	public static final String RECORD_INSERTED_SUCCESSFULLY = "Record Inserted Successfully";
	public static final String WARNING = "Warning";
	public static final String ERROR = "Error";
	public static final String OTP_SENT_SUCCESS = "Otp sent Successfully";
	public static final String STUDENTNODUE = "NODUE";
	public static final String INVALID_STD = "INVALID STUDENT";
	public static final String ERROR_IN_STD_FEE_INST = "Error in Student Fee Installments";
	public static final String INSTALLMENTS_ARE_NULL = "Please Enter Installment Amount";
	public static final String POCKET_MONEY_ISSUED_SUCESSFULLY = "Pocket money issued sucessfully";
	public static final String DAYSHEET_CLOSED = "Daysheet closed sucessfully";
	public static final String STUDENT_CANCELLED_SUCCESSFULLY = "Student cancelled successfully";
	public static final String STUDENT_TC_CANCELLED_SUCCESSFULLY = "Student TC cancelled successfully";
	public static final String STUDENT_ALREADY_CANCELLED = "Student Already Cancelled";
	public static final String STUDENT_TC_ALREADY_CANCELLED = "Student TC Already Cancelled";
	public static final String POCMON_UPDATED = "Pocket Money Updated Successfully";
	public static final String REFUND_SENT_SUCCESSFULLY = "Refund sent Successfully";
	public static final String CANCEL_SUCCESSFULLY = "Cancel Successfully";
	public static final String APPROVED_SUCCESSFULLY = "Approved Successfully";
	public static final String REJECT_SUCCESSFULLY = "Rejected Successfully";
	public static final String FEEDBACKMSG = "Attendance Data Not Found.Please Approve Later.";
	public static final String NODATAFOUND = "No Data Found";
	public static final String VALIDCLASS = "Please Enter valid Class Name";
	public static final String VALIDBARCODE = "Please enter a valid Product Code: ";
	public static final String VALIDSTREAM = "Please Enter valid stream Name";
	public static final String VALIDACADEMICYEAR = "Please enter a valid Academic Year: ";
	public static final String ALREADYEXIST = "Akash Books entry already exists for Barcode: ";
	public static final String UPADATE = "Update";
	public static final String SENDING_REQUEST_SUCCESSFUL = "Sending Request Successful";
	public static final String SAVE_REQUEST_SUCCESSFUL = "Save Request Successful";
	public static final String STATUS_UPDATED_AS_FALSE = "Status updated as False";
	public static final String EXCESSCOURSEFEE = "Excess course fee payments are not allowed!";
	public static final String NODUEAKASHBOOKS = "There is no due for Akash Book Fee!";
	public static final String SECTION_CREATED_SUCCESSFULLY = "Section Created Successfully";
	public static final String SECTION_UPDATED_SUCCESSFULLY = "Section Updated Successfully";
	public static final String SECTION_DEACTIVATED_SUCCESSFULLY = "Section Deactivated Successfully";
	public static final String NO_SECTION_TO_DEACTIVATED = "No Section to Deactivated";
	public static final String BED_DISLOACATED = "Bed deallocated";
	public static final String BED_Allocated = "Bed Allocated ";
	
	
	public static final String AADHARNO = "what is your aadhar number";
	public static final String AADHARNAME = "what is your aadhar name";
	public static final String PHONENO = "what is your registration phone number";
	public static final String DOB = "what is your DOB(dd/mm/yyyy)";
	public static final String DOJ = "what is your DOJ(dd/mm/yyyy)";
	public static final String PANNO = "what is your pan number";
	
	
	public interface FormatDates {
		public static final String DATEFORMAT = "dd/MM/yyyy";
		public static final String DATEFORMAT2 = "dd-MM-yyyy";
		public static final String DATEFORMAT3 = "yyyy-MM-dd";
	}

	public interface AppraisalPeriod {
		public static final String APPRAISAL_PERIOD = "Jun-2021 - May-2022";
		public static final String NEXT_YEAR_KRA_PERIOD = "Jun-2022 - May-2023";
	}

	public interface StudentType {

		public static final String RESIDENTIAL = "RESIDENTIAL";
		public static final String DAYSCHOLAR = "DAYSCHOLAR";
		public static final String TRANSFERREDNC = "TRANSFERREDNC";
		public static final String SINGLE = "SINGLE";
		public static final String BULK = "BULK";

	}

	public interface FeedBackMessageType {
		public static final String ERROR = "ERROR";
		public static final String INFO = "INFO";
		public static final String SUCCESS = "SUCCESS";
	}

	public interface AppraisalStatus {
		public static final String APPRAISAL_PENDING_STATUS = "Pending";
		public static final String APPRAISAL_NEW_STATUS = "New";
		public static final String APPROVED = "Approved";
		public static final String REJECTED = "Rejected";
		public static final String COMPLETED = "Completed";
		public static final String APPRAISER2_REJECTED = "Appraiser2 Rejected";

		public static final String APPRAISER1_APPROVE_STATUS = "Approved";
		public static final String APPRAISER1_REJECT_STATUS = "Rejected";
		public static final String APPRAISER2_APPROVE_STATUS = "Completed";

		public static final String APPRAISER1_APPROVED_STATUS = "Appraiser1 Approved";
		public static final String APPRAISER1_REJECTED_STATUS = "Appraiser1 Rejected";
		public static final String APPRAISER2_APPROVED_STATUS = "Appraiser2 Approved";
		public static final String APPRAISER2_REJECTED_STATUS = "Appraiser2 Rejected";
	}

	public interface SMSStatus {
		public static final int SMS_STATUS_IN_QUEUE = 0;
		public static final int SMS_STATUS_SENT_TO_SP = 3;

		public static final int INVALID_INPUT_DATA = -1;
		public static final int INVALID_ACCOUNT = -2;
		public static final int INVALID_SENDER = -3;
		public static final int INSUFFICIENT_FUNDS = -4;
		public static final int INVALID_NUMBER = -5;
		public static final int UNDELIVERED = -6;
		public static final int REJECTED = -7;
		public static final int MEMEXEC = -8;
		public static final int ABSENT = -9;
		public static final int UNKNOWN = -10;
		public static final int MOBOFF = -11;
		public static final int EXPIRED = -12;
		public static final int BARRING = -13;
		public static final int MOBERR = -14;
		public static final int UNKNOWN_LONG_PENDING = -15;
		public static final int SERIESBLOCK = -16;
		public static final int GENERIC_INVALID = -50;

		public static final int SUBMITTED = 5;
		public static final int DELIVERED = 6;

		public static final int SMS_STATUS_ERROR_OTHER = -98;
		public static final int SMS_STATUS_OPTED_OUT = -99;
		public static final int SMS_CONNECTION_TIME_OUT = 0;

	}

	public interface GST {
		public static final String STATE = "STATE";
		public static final String CENTRAL = "CENTRAL";
	}

	public interface LeaveStatus {

		public static final String LEAVE_REQUESTED = "REQUESTED";

		public static final String LEAVE_APPROVED1 = "APPROVED1";

		public static final String LEAVE_APPROVED2 = "APPROVED2";

		public static final String LEAVE_APPROVED3 = "APPROVED3";

		public static final String LEAVE_APPROVED = "APPROVED";

		public static final String LEAVE_CANCELLED = "CANCELLED";

		public static final String LEAVE_REJECTED = "REJECTED";

	}

	public interface LeaveType {

		public static final String ONDUTY = "On Duty";

		public static final String LEAVE_REQUEST = "Leave Request";

		public static final String LEAVE_CANCELLED = "Leave Cancelled";

		public static final String CHECK_DATES = "Please check the dates,Already exists!!";

		public static final String CHECK_TIMINGS = "Please verify the in time and out time.";

		public static final String MANAGER_NOT_MAPPED = "Sorry,Manager is not mapped!!";

		public static final String INVALIDPAYROLLID = "Employee not found for payroll ID:";
	}

	public interface LoginException {

		public static final String USER_NOT_EXIST = "Invalid Username";
		public static final String INVALID_PWD = "Invalid password";
		public static final String INVALID_CLINET = "Invalid clinet";

		public static final String DEVICE_ID_NOT_FOUND = "Unable to get Device ID";

		public static final String DEVICE_ID_ALREADY_EXIST = "Already Logged in another Device please Logout and try again";

		public static final String INVALID_ROLE_PERMISSION = "Sorry, user does not have permission! to login";

		public static final String APP_NAME_NOT_FOUND = "Unable to get AppName";

		public static final String CONTACT_PASSWORD_NULL = "Password is not genrated please contact campus principle";

		public static final String INVALID_JWT = "Invalid JWToken";
		public static final String INVALID_USER_ID = "Invalid User Id in JWT";
		public static final String FIRE_BASE_ERROR = "Fire Base Login Failed";
		public static final String INVALID_USER_CREDENTIALS = "Invalid user credentials";
		public static final String LOGIN_EXPIRED = "Please contact support because of you didn't login since 45 days";
		public static final String WRONG_PASSWORD = "Wrong password, You have 4 login attempts left.";
		public static final String ACCOUNT_BLOCKED = "Wrong password, Your account Blocked(5 wrong attempts). You may unlock your username by clicking on the 'Trouble Logging In?' link below";
		public static final String LOGIN_BLOCKED = "Login Blocked";
		public static final String ENTER_CREDENTIALS = "Please Enter UserId and Password";

	}

	public static final long DHOBHI_REFUND = 2;

	public static final long INTER1 = 1L;
	public static final long INTER2 = 2L;
	public static final long DEGREE1 = 7L;
	public static final long DEGREE2 = 8L;
	public static final long DEGREE3 = 9L;
	public static final long PG1 = 14L;
	public static final long PG2 = 15L;
	public static final long LONG_TERM = 6L;
	public static final long SHORT_TERM = 3L;
	public static final long OYP = 4L;
	public static final long TYP1 = 5L;
	public static final long TYP2 = 16L;
	public static final long IIT_FOUNDATION_8TH = 11L;
	public static final long IIT_FOUNDATION_9TH = 12L;
	public static final long IIT_FOUNDATION_10TH = 13L;
	public static final long CLASS_6TH = 17L;
	public static final long CLASS_7TH = 18L;
	public static final long CLASS_8TH = 19L;
	public static final long CLASS_9TH = 20L;
	public static final long CLASS_10TH = 21L;

	public interface SchoolConstants {
		public static String COLLEGE = "COLLEGE";
		public static String SCHOOL = "SCHOOL";
		public static String ROOKIE = "ROOKIE";
	}

	public interface EmloyeeLeaveConstants {
		public static final String REQUESTED = "REQUESTED";
		public static final String APPROVED = "APPROVED";
		public static final String REJECTED = "REJECTED";
		public static final String CANCELLED = "CANCELLED";

	}

	public interface ParentVisit {
		public static final String CAMPUS_VISITORS = "/CAMPUS_VISITORS/";
		public static final String GUARDIAN = "GUARDIAN";
		public static final String VISITOR = "VISITOR";
		public static final String OTHERS = "OTHERS";
	}

	public interface Subject {

		public static final String MATHEMATICS = "MATHEMATICS";
		public static final String PHYSICS = "PHYSICS";
		public static final String CHEMISTRY = "CHEMISTRY";
		public static final String BOTANY = "BOTANY";
		public static final String ZOOLOGY = "ZOOLOGY";
		public static final String SOCIAL = "SOCIAL";
		public static final String REASONING = "REASONING";
		public static final String TOTAL = "TOTAL";

	}

	public interface GST_TYPES {
		public static String CENTRAL = "CENTRAL";
		public static String STATE = "STATE";
	}

	public interface SubjectID {

		public static final int MATHEMATICS = 101;
		public static final int PHYSICS = 106;
		public static final int CHEMISTRY = 107;
		public static final int BOTANY = 102;
		public static final int ZOOLOGY = 103;
		public static final int SOCIAL = 104;
		public static final int REASONING = 105;
		public static final int TOTAL = 999;

	}

	public interface FeePayment {
		public static final String PAID = "PAID";
		public static final String _PAID = "_PAID";
		public static final String CONCESSION = "CONCESSION";
		public static final String _CONCESSION = "_CONCESSION";
		public static final String DUE = "DUE";
		public static final String _DUE = "_DUE";
		public static final String _TAX_PAID = "_TAX_PAID";
		public static final String _SERVICE_TAX_PAID = "_SERVICE_TAX_PAID";
		public static final String _SERVICE_TAX_EXCLUDE_PAID = "_SERVICE_TAX_EXCLUDE_PAID";
		public static final String _COURSE_CHANGE_PENALTY_DUE = "_COURSE_CHANGE_PENALTY_DUE";
		public static final String _ADD_COURSE_FEE_DUE = "_ADD_COURSE_FEE_DUE";
		public static final String SERVICE_TAX_DUE = "SERVICE_TAX_DUE";
		public static final String COURSE_CHANGE_PENALTY_PAID = "COURSE_CHANGE_PENALTY_PAID";
		public static final String ADD_COURSE_FEE_PAID = "ADD_COURSE_FEE_PAID";
		public static final String _COURSE_CHANGE_PENALTY_PAID = "_COURSE_CHANGE_PENALTY_PAID";
		public static final String _ADD_COURSE_FEE_PAID = "_ADD_COURSE_FEE_PAID";
	}

	public final Map<String, Integer> SUBJECT_MAP = createSubIdForSort();

	static Map<String, Integer> createSubIdForSort() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		result.put(Subject.MATHEMATICS, SubjectID.MATHEMATICS);
		result.put(Subject.PHYSICS, SubjectID.PHYSICS);
		result.put(Subject.CHEMISTRY, SubjectID.CHEMISTRY);
		result.put(Subject.BOTANY, SubjectID.BOTANY);
		result.put(Subject.ZOOLOGY, SubjectID.ZOOLOGY);
		result.put(Subject.SOCIAL, SubjectID.SOCIAL);
		result.put(Subject.REASONING, SubjectID.REASONING);
		result.put(Subject.TOTAL, SubjectID.TOTAL);

		return Collections.unmodifiableMap(result);
	}

	public static final long MATHS_CAT_ID = 1;
	public static final long PHY_CAT_ID = 548;
	public static final long CHE_CAT_ID = 1125;

	public static final long BOT_CAT_ID = 2745;
	public static final long ZOO_CAT_ID = 2747;

	public static final long ECO_CAT_ID = 10389;
	public static final long POLITICAL_SCIENCE_CAT_ID = 10391;
	public static final long SOCIOLOGY_CAT_ID = 10394;

	public static final long HIST_CAT_ID = 10390;
	public static final long ECONOMICS_CAT_ID = 10389;
	public static final long PUBLIC_ADMINISTRATION_CAT_ID = 10392;

	public static final long GEOGRAPHY_CAT_ID = 10393;

	public static final String FAILED_DEPENDENCY = "Failed Dependency";

	public interface EmpRecruitProcess {

		public static final long PENDING_AT_SUPER_ADMIN = 15;
		public static final long REJECT_AT_SUPER_ADMIN = 16;
		public static final long APPROVED_AT_SUPER_ADMIN = 1;
		public static final String PENDING_SUPER_ADMIN_LEVEL = "PENDING AT SUPER ADMIN";
		public static final String APPROVED_SUPER_ADMIN_LEVEL = "APPROVED AT SUPER ADMIN";
		public static final String PENDING = "PENDING";
		public static final String APPROVED = "APPROVED";
		public static final String REJECTED = "REJECTED";
		public static final String CURRENT = "CURRENT";

	}

	public interface studentMessages {

		public static final String ENTER_ENGLISH_MARKS = "Please Enter English Marks.";
		public static final String ENTER_HINDI_MARKS = "Please Enter Hindi Marks.";
		public static final String ENTER_MATHS_MARKS = "Please Enter Maths Marks.";
		public static final String ENTER_MARKS = "Please Enter  Marks.";
		public static final String STUDENT_DETAILS_ENTERING_FAILED = "Student In details entering is failed";
		public static final String FAILED_TOSAVE_CONCESSION = "Failed to save concession details.";
		public static final String NOT_ACCEPTED_CONCESSION = "Sorry! does not accepted concession,as the student due is 0.";
		public static final String NOT_ACCEPTED_EXCESS_CONCESSION = "Sorry! does not accepted concession,as the student paid excess amount.";
		public static final String NOT_ACCEPTED_EXCESS_CONCESSION_LIMIT = "Sorry! does not accepted concession,as the student concession limit exceeds,Please Contact Support";
		public static final String FAILED_STUDENT_TRANSFER = "Unable to save Student Transfer";
		public static final String CONCESSION_FAILED = "Concession not Updated Please Contact Support.";
		public static final String NOT_ACCEPT_CONCESSION = "Sorry! does not accepted concession.";
		public static final String CONCESSION_NOT_ACCEPT = "Sorry! concession is not accepted for higher classes";
		public static final String REFUND_FAILED = "Refund Failed";
		public static final String STUDENT_TRANSFERED = "Student transfered is successfully done, Transfer letter Number : ";
		public static final String HALL_TICKET_FAILED = "Hall Ticket Failed";
		public static final String HALL_TICKET_SUCCESSFULLY = "Hall Ticket Successfully done";
		public static final String NO_STUDENT_RECORDS_TOSAVE = "No Student Record To Save";
		public static final String feedbackMessage = "Sorry!  This student transfer  reached maximum attempts ,Please contact support team .";
		public static final String PAYMENTFAILED = "Sorry! Payment Failed.";
		public static final String TIMEOUT = "Payment timeout. Please try again";
		public static final String TRYAGAIN = "Please try again";

	}

	public interface StudentActivities {

		public static final String CONCESSION = "Student Concession";
		public static final String TALENT_TEST = "TALENT TEST";
		public static final String TENTH_MARKS = "10TH MARKS";
		public static final String OTHERS = "OTHERS";
		public static final String STU_COURSE_DES = "Student Course updated";
		public static final String STU_TRANSFER_DES = "Student Transfered";

	}

	public interface AppStatus {
		public static final String AT_CA = "AT_CA";
		public static final String AT_DG = "AT_DG";
		public static final String AT_ZO = "AT_ZO";
		public static final String AT_CE = "AT_CE";

	}

	public interface EmpDocs {
		public static final String PATH = "/empdocuments/";
		public static final String PHOTO = "Photo";
	}

	public interface UrlShortener {

		public static final String shortenerUrl = "https://msg.scaits.net/";
		public static final String employeeApp = "https://play.google.com/store/apps/details?id=employee.apps.srichaitanya.com.employee";
		public static final String webPortal = "http://scaits.info/employee/dashboard";
		public static final String smsUrl = "http://api.instaalerts.zone/SendSMS/sendmsg.php?uname=varsitytr&pass=5cil1nfm5@123";
	}

	public interface JWToken {
		public interface Subject {
			public static final String STUDENT_PROGRESS_REPORT = "ProgressReport";
			public static final String EMPLOYEE_DOCUMENTS = "EmployeeDocumets";
		}

		public interface Id {
			public static final String USER_ID = "userId";
			public static final String PAYROLL_ID = "payrollId";
			public static final String EMPLOYEE_ID = "employeeId";
		}

		public interface JWTClaims {
			public static final String ADM_NO = "admNo";
			public static final String MOBILE_NO = "mobileNo";
			public static final String UNIQUE_ID = "uniqueId";
			public static final String PAYROLL_ID = "payrollId";
			public static final String JWT_TYPE = "type";
		}
	}

	public interface CommonMessages {

		public static final String INVALID_LOGIN_DETAILS = "Invalid Login Details...";

	}

	public interface SectionUpdateResponseMessages {

		public static final String INVALID_SECTION_DETAILS = "Invalid section details...";
		public static final String INVALID_FROM_SECTION = "Invalid from section Id...";
		public static final String INVALID_TO_SECTION = "Invalid to section Id...";
		public static final String SUCCESS = "Section Updated Successfully...";
		public static final String INVALID_STUDENT_LIST = "Invalid student details..";
	}

	public interface RoomAccommodationMessage {

		public static final String INVALID_ROOM = "Invalid room details...";
		public static final String SUCCESS = "Room Allotted Successfully...";
		public static final String INVALID_STUDENT_LIST = "Invalid student details..";
		public static final String INVALID_ROOM_ID = "Invalid RoomId...";

	}

	public interface SaveRoomAccommodationMessage {

		public static final String INVALID_FLOOR_ID = "Invalid Floor Id...";
		public static final String SUCCESS = "Room Details Submitted Successfully...";
		public static final String INVALID_DEATILS = "Room Not Updated...";
		public static final String INVALID_ROOM_ID = "Invalid Room Id...";

	}

	public interface ROOM_ACCOMODATION_STATUS {
		public static final String OCCUPIED = "OCCUPIED";
		public static final String VACATED = "VACATED";
	}

	public interface SaveExamProgramMessage {

		public static final String INVALID_STREAM_ID = "Invalid Stream Id...";
		public static final String INVALID_EXAM_PROGRAM_NAME = "Invalid Exam Program Name";
		public static final String SUCCESS = "ExamProgram  saved Successfully...";
	}

	public interface ExamProgramResponseMessages {
		public static final String INVALID_ADMNO = "Invalid AdmNo...";
		public static final String SUCCESS = "ExamProgram AdmNo saved Successfully...";
	}

	public interface ExamProgramUpdateResponseMessages {

		public static final String INVALID_EXAM_PROGRAM_DETAILS = "Invalid ExamProgram details...";
		public static final String INVALID_FROM_EXAM_PROGRAM = "Invalid from ExamProgram Id...";
		public static final String INVALID_TO_EXAM_PROGRAM = "Invalid to ExamProgram Id...";
		public static final String SUCCESS = "ExamProgram Updated Successfully...";
		public static final String INVALID_STUDENT_LIST = "Invalid student details..";
	}

	public interface BuildingRoomImages {
		public static final String PATH = "/BuildingRoomImages/";
		public static final String PHOTO = "Photo";
	}

	public interface SaveStudentAttendanceResponseMessages {
		public static final String INVALID_SECTION_DETAILS = "Invalid section details...";
		public static final String SUCCESS = "Student attendance saved Successfully...";
	}

	public interface SaveRookieDetailsResponse {
		public static final String SUCCESS = "Data Inserted Successfully...";
	}

	public interface SaveBiometricDetails {
		public static final String SUCCESS = "Data Inserted Successfully...";
	}

	public interface SaveRookieDetailsResp {
		public static final String SUCCESS = "Data Updated Successfully...";
	}

	public interface SaveRookieDetails {
		public static final String Message = "Please Enter All the Details";
	}

	public interface SaveBiometric {
		public static final String Message = "Please Enter All the Details";
	}

	public interface OAuth {

		public static final String cmsEnquiry = "cmsEnquiry";
		// public static final String fireBaseJson =
		// "/home/ubuntu/SSL_BBE/FireBaseJson/varsitybbe-a2f27-firebase-adminsdk-8grro-df4177436b.json";
		// public static final String fireBaseJson =
		// "D:/employee-app-9d08e-firebase-adminsdk-mklau-c3ecf659eb.json";
		public static final String fireBasePath = "https://employee-app-9d08e-default-rtdb.firebaseio.com";
		public static final String uuid = "uuid";
		public static final String username = "username";

	}

	public interface SavefacultyAllocationMessage {
		public static final String INVALID_SECTION_DETAILS = "Invalid section details...";
		public static final String SUCCESS = "Faculties class allocation successfully done...";
	}

	public interface DateTimeFormates {
		public static final String dd_MM_yyyy_HH_mm = "dd-MM-yyyy HH:mm";
		public static final String DAY_START_TIME = "00:00";
	}

	public interface SaveEmployeeChangeCampus {

		public static final String INVALID_CAMPUS_ID = "Invalid Selected Campus";
		public static final String SUCCESS = "Employe Campus changed successfully...";
		public static final String CAMPUS_NOT_FOUND_SELECTED_CITY = "Campus not available for this selected city";
	}

	public interface OracleStatus {
		public static String STUDENT_UPDATE = "SU";
		public static String COURSE_UPDATE = "CU";
		public static String COURSE_UPDATE_ADDITIONNAL = "CU";
		public static String STUDENT_TRANSFER = "ST";
		public static String STUDENT_CONFIRMATION = "SC";
		public static String CONCESSION = "CO";
		public static String SECTION = "SE";
		public static String APPLICATION_SALES = "AS";
		public static String CONFIRMED = "CONFIRMED";

	}

	public interface TransferFiles {
		public static String ORIGINAL_APPLICATION = "ORIGINAL APPLICATION";
		public static String TC = "T.C";
		public static String MEMO = "MEMO";

	}

	public interface Source {
		public static String TRANSFER = "TRANSFER";
		public static String COURSE = "COURSE";
	}

	public interface OnlineApplicationSales {
		public static String PAYMENTSUCCESS = "Payment done successfully";
		public static String STUDENTINFOSAVESUCCESSFULLY = "Student information saved successfully";
		public static String ADDRESSINFOSAVESUCCESSFULLY = "Address information saved successfully";
		public static String CONCESSIONINFOSAVESUCCESSFULLY = "Concession information saved successfully";
		public static String HALLTICKETINFOSAVESUCCESSFULLY = "Hall ticket information saved successfully";
		public static String COURSEINFOSAVESUCCESSFULLY = "Course information saved successfully";
		public static String SCHOOLINFOSAVESUCCESSFULLY = "School information saved successfully";
		public static String AKASHBOOKSNETBANKING = "Akaash Books Amount Paid From Net Banking";
		public static String AKASHBOOKS = "AKASH_BOOKS";
		public static String POCKETMONEYNETBANKING = "Pocket Money Paid From Net Banking";
		public static String FEEPAIDNETBANKING = "Fee Paid From Net Banking";
		public static String SKCT = "SKCT";
		public static String ZEROS = "000";
		public static String CHECK_COURSE_FEE = "Please check Course fee priority/ Stage gst heads";

		public static String COURSEFEEDBACK = "Course Fee structure not define please contact support...";

		public static String AKASHBOOKSFEEDBACK = "Akash Books Fee structure not define please contact support...";

		public static String AKASHBOOKENTER = "Entrer Akash Books amount";

		public static String AKASHBOOKNODUE = "There is no due for Akash Book Fee!";

		public static String GSTDETAILSDEFINED = "GST details are not defined for this payment...";
	}

	public interface Fusion {
		public static final String SEGMENT3 = "SEGMENT3";
		public static final String COLLECTIONS = "Collections";
		public static final String POCKET_MONEY_CASH = "Pocket Money Cash";
		public static final String POCKET_MONEY_SPENT = "Pocket Money Spent";
		public static final String DEPOSITS = "Deposits";
		public static final String INTEGRATION_TABLE = "XXVST_REV_DAILY_COL_STG";
		public static final String MONTHLY_REFUND_TBL = "XXVST_REV_MONTHLY_REF_STG";
		public static final String SEGMENT5 = "SEGMENT5";
		public static final String CASH = "CASH";
		public static final String DEBIT = "DEBIT";
		public static final String CREDIT = "CREDIT";
		public static final String BANK = "BANK";
		public static final String CARD = "CARD";
		public static final String CHEQUE = "Cheque";
		public static final String DD = "DD";
		public static final String IPG_Razorpay = "IPG_Razorpay";
		public static final String IPGBharatpay = "IPGBharatpay";
		public static final String IPG_Grayquest = "IPG_Grayquest";
		public static final String IPG_Paytm = "IPG_Paytm";
		public static final String Cash = "Cash";
		public static final String LINE = "LINE";
		public static final String POI_STAGING_TBL = "XXVST_REVENUE_POI_STG";
		public static final String IPG_HDFC = "IPG_HDFC";
		public static final String IPG_Axis_Bank = "IPG_Axis_Bank";
		public static final String IPG_ICICI = "IPG_ICICI";

	}

	public interface AkashBooks {

		public static final String STUDENT = "STUDENT";
		public static final String ISSUED = "ISSUED";
		public static final String REVERSAL = "REVERSAL";

	}

	public interface MetaStatus {
		public static final String SN = "SN";
		public static final String SU = "SU";
	}
	
	public interface MappingStatus {
		public static final String ENABLED = "ENABLED";
		public static final String DISABLED = "DISABLED";
		public static final String APPROVED = "APPROVED";
		public static final String REJECTED = "REJECTED";
		public static final String TRANSFERED = "TRANSFERED";
		public static final String REQUEST = "REQUEST FOR APPROVAL";
		public static final String CONFIRMED = "CONFIRMED";
		public static final String REQUESTED = "REQUESTED";

	}
	
	public interface AuthenticationMessages {
		public static final String PASSWORD_CHANGED = "Your Password Changed Successfully";
		public static final String PASSWORD_DOESNT_MATCH = "Your Confirmation password doesn't match";
		public static final String PASSWORD_INCORRECT = "Password you entered is incorrect";
		public static final String PAYROLLID_INCORRECT = "Payrollid you entered is incorrect";
		public static final String PAYROLLID_INVALID = "Invalid PayRoll ID";
		public static final String ENTER_VALID_PAYROLLID = "Please Enter Valid Payroll Id";
		public static final String CONTACT_SUPPORT = "Please Contact Support Team";
		public static final String OTP_PASSWORD_SENT = "OTP PASSWORD SENT TO THE MOBILE NUMBER ";
		public static final String PASSWORD_NOT_VALID = "Confirmation Password is not Valid";
		public static final String ENTER_VALID_PASSWORD = "Please Enter valid Password";
		public static final String ENTER_VALID_OLDPASSWORD = "Please Enter Old Password Correctly";

		public static final String PASSWORD_DOESNT_MATCH_PREVIOUS = "New password cannot be as same as your previous 3 password(s)";

	}

}
