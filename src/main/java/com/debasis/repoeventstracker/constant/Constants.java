package com.debasis.repoeventstracker.constant;

/**
 * 
 * @author Debasis Panda
 *
 */
public final class Constants {

	private Constants() {
		
	}
	
	public static String EVENTS = "events";
	
	/**
	 * Events Types are available in below link.
	 * <p>
	 *    1.Types are hard coded now but this can be stored in DB as master data.
	 *    2.Elastic cache can be used to for faster retrieval</p>
	 * Link: https://developer.github.com/v3/activity/events/types/
	 */
	public static String[] EVENT_TYPES = new String[] { "CheckRunEvent", "CheckSuiteEvent", "CommitCommentEvent",
			"ContentReferenceEvent", "CreateEvent", "DeleteEvent", "DeployKeyEvent", "DeploymentEvent",
			"DeploymentStatusEvent", "DownloadEvent", "FollowEvent", "ForkEvent", "ForkApplyEvent",
			"GitHubAppAuthorizationEvent", "GistEvent", "GollumEvent", "InstallationEvent",
			"InstallationRepositoriesEvent", "IssueCommentEvent", "IssuesEvent", "LabelEvent",
			"MarketplacePurchaseEvent", "MemberEvent", "MembershipEvent", "MetaEvent", "MilestoneEvent",
			"OrganizationEvent", "OrgBlockEvent", "PageBuildEvent", "ProjectCardEvent", "ProjectColumnEvent",
			"ProjectEvent", "PublicEvent", "PullRequestEvent", "PullRequestReviewEvent",
			"PullRequestReviewCommentEvent", "PushEvent", "RegistryPackageEvent", "ReleaseEvent", "RepositoryEvent",
			"RepositoryImportEvent", "RepositoryVulnerabilityAlertEvent", "SecurityAdvisoryEvent", "StarEvent",
			"StatusEvent", "TeamEvent", "TeamAddEvent", "WatchEvent" };
	
}
