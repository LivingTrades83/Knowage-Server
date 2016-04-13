package it.eng.spagobi.metadata.metadata;

// Generated 12-apr-2016 10.43.25 by Hibernate Tools 3.4.0.CR1

import it.eng.spagobi.commons.metadata.SbiHibernateModel;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SbiMetaJob generated by hbm2java
 */
public class SbiMetaJob extends SbiHibernateModel {

	private Integer jobId;
	private String name;
	private boolean deleted;
	private String userIn;
	private String userUp;
	private String userDe;
	private Date timeIn;
	private Date timeUp;
	private Date timeDe;
	private String sbiVersionIn;
	private String sbiVersionUp;
	private String sbiVersionDe;
	private String metaVersion;
	private String organization;
	private Set sbiMetaJobSources = new HashSet(0);
	private Set sbiMetaJobTables = new HashSet(0);

	public SbiMetaJob() {
	}

	public SbiMetaJob(String name, boolean deleted, String userIn, Date timeIn) {
		this.name = name;
		this.deleted = deleted;
		this.userIn = userIn;
		this.timeIn = timeIn;
	}

	public SbiMetaJob(String name, boolean deleted, String userIn, String userUp, String userDe, Date timeIn, Date timeUp, Date timeDe, String sbiVersionIn,
			String sbiVersionUp, String sbiVersionDe, String metaVersion, String organization, Set sbiMetaJobSources, Set sbiMetaJobTables) {
		this.name = name;
		this.deleted = deleted;
		this.userIn = userIn;
		this.userUp = userUp;
		this.userDe = userDe;
		this.timeIn = timeIn;
		this.timeUp = timeUp;
		this.timeDe = timeDe;
		this.sbiVersionIn = sbiVersionIn;
		this.sbiVersionUp = sbiVersionUp;
		this.sbiVersionDe = sbiVersionDe;
		this.metaVersion = metaVersion;
		this.organization = organization;
		this.sbiMetaJobSources = sbiMetaJobSources;
		this.sbiMetaJobTables = sbiMetaJobTables;
	}

	public Integer getJobId() {
		return this.jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getUserIn() {
		return this.userIn;
	}

	public void setUserIn(String userIn) {
		this.userIn = userIn;
	}

	public String getUserUp() {
		return this.userUp;
	}

	public void setUserUp(String userUp) {
		this.userUp = userUp;
	}

	public String getUserDe() {
		return this.userDe;
	}

	public void setUserDe(String userDe) {
		this.userDe = userDe;
	}

	public Date getTimeIn() {
		return this.timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	public Date getTimeUp() {
		return this.timeUp;
	}

	public void setTimeUp(Date timeUp) {
		this.timeUp = timeUp;
	}

	public Date getTimeDe() {
		return this.timeDe;
	}

	public void setTimeDe(Date timeDe) {
		this.timeDe = timeDe;
	}

	public String getSbiVersionIn() {
		return this.sbiVersionIn;
	}

	public void setSbiVersionIn(String sbiVersionIn) {
		this.sbiVersionIn = sbiVersionIn;
	}

	public String getSbiVersionUp() {
		return this.sbiVersionUp;
	}

	public void setSbiVersionUp(String sbiVersionUp) {
		this.sbiVersionUp = sbiVersionUp;
	}

	public String getSbiVersionDe() {
		return this.sbiVersionDe;
	}

	public void setSbiVersionDe(String sbiVersionDe) {
		this.sbiVersionDe = sbiVersionDe;
	}

	public String getMetaVersion() {
		return this.metaVersion;
	}

	public void setMetaVersion(String metaVersion) {
		this.metaVersion = metaVersion;
	}

	public String getOrganization() {
		return this.organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Set getSbiMetaJobSources() {
		return this.sbiMetaJobSources;
	}

	public void setSbiMetaJobSources(Set sbiMetaJobSources) {
		this.sbiMetaJobSources = sbiMetaJobSources;
	}

	public Set getSbiMetaJobTables() {
		return this.sbiMetaJobTables;
	}

	public void setSbiMetaJobTables(Set sbiMetaJobTables) {
		this.sbiMetaJobTables = sbiMetaJobTables;
	}

}
