METADATA_SCM = "${@base_get_scm(d)}"
METADATA_REVISION = "${@base_get_scm_revision(d)}"
METADATA_BRANCH = "${@base_get_scm_branch(d)}"

def base_get_scm(d):
	from bb import which
	baserepo = os.path.dirname(os.path.dirname(which(d.getVar("BBPATH", 1), "classes/base.bbclass")))
	for (scm, scmpath) in {"svn": ".svn",
			       "git": ".git",
			       "monotone": "_MTN"}.iteritems():
		if os.path.exists(os.path.join(baserepo, scmpath)):
			return "%s %s" % (scm, baserepo)
	return "<unknown> %s" % baserepo

def base_get_scm_revision(d):
	(scm, path) = d.getVar("METADATA_SCM", 1).split()
	try:
		if scm != "<unknown>":
			return globals()["base_get_metadata_%s_revision" % scm](path, d)
		else:
			return scm
	except KeyError:
		return "<unknown>"

def base_get_scm_branch(d):
	(scm, path) = d.getVar("METADATA_SCM", 1).split()
	try:
		if scm != "<unknown>":
			return globals()["base_get_metadata_%s_branch" % scm](path, d)
		else:
			return scm
	except KeyError:
		return "<unknown>"

def base_get_metadata_monotone_branch(path, d):
	monotone_branch = "<unknown>"
	try:
		monotone_branch = file( "%s/_MTN/options" % path ).read().strip()
		if monotone_branch.startswith( "database" ):
			monotone_branch_words = monotone_branch.split()
			monotone_branch = monotone_branch_words[ monotone_branch_words.index( "branch" )+1][1:-1]
	except:
		pass
	return monotone_branch

def base_get_metadata_monotone_revision(path, d):
	monotone_revision = "<unknown>"
	try:
		monotone_revision = file( "%s/_MTN/revision" % path ).read().strip()
		if monotone_revision.startswith( "format_version" ):
			monotone_revision_words = monotone_revision.split()
			monotone_revision = monotone_revision_words[ monotone_revision_words.index( "old_revision" )+1][1:-1]
	except IOError:
		pass
	return monotone_revision

def base_get_metadata_svn_revision(path, d):
	revision = "<unknown>"
	try:
		revision = file( "%s/.svn/entries" % path ).readlines()[3].strip()
	except IOError:
		pass
	return revision

def base_get_metadata_git_branch(path, d):
	branch = os.popen('cd %s; PATH=%s git symbolic-ref HEAD 2>/dev/null' % (path, d.getVar("PATH", 1))).read().rstrip()

	if len(branch) != 0:
		return branch.replace("refs/heads/", "")
	return "<unknown>"

def base_get_metadata_git_revision(path, d):
	rev = os.popen("cd %s; PATH=%s git show-ref HEAD 2>/dev/null" % (path, d.getVar("PATH", 1))).read().split(" ")[0].rstrip()
	if len(rev) != 0:
		return rev
	return "<unknown>"
