package com.model;

public class Student {
	
		private int studentid;
		private String stuname;
		private int age;
		private String stream;
		private String eventtype;

		public String getEventtype() {
			return eventtype;
		}

		public void setStudentid(int studentid) {
			this.studentid = studentid;
		}

		public void setStuname(String stuname) {
			this.stuname = stuname;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public void setStream(String stream) {
			this.stream = stream;
		}

		public void setEventtype(String eventtype) {
			this.eventtype = eventtype;
		}

	

		public int getStudentid() {
			return studentid;
		}

		public String getStuname() {
			return stuname;
		}

		public int getAge() {
			return age;
		}

		public String getStream() {
			return stream;
		}

		public String getEventtpe() {
			return eventtype;
		}

		public String toString() {
			return studentid + ", id: " + stuname + ", name: " + age + ", age: " + stream + ", stream: " + eventtype
					+ "eventtype";
		}

		public void display() {

		}

		public void displayStudent() {
		}

	}

