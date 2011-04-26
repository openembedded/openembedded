# ############################################################################
# Helper functions for building packages from the trunk or branches. To use
# this .bbclass simply inherit from it in your conf/local.conf.
#
# - get_branch() helps to construct the package name when fetching by 
#   extracting the directory name above the "build" directory containing the
#   oe environment and bitbake. That directory name is usually the branch in
#   which the package is located in the svn with one exception: "unstable"
#   is synonymous for "trunk". In the package you can then use the ${BRANCH}
#   variable within the svn (or cvs) url for the package.
#
# - get_tomorrow() makes sure the latest version of a package is fetched. To
#   use it, set the SRCDATE to ${TOMORROW}.
# ############################################################################

def get_branch():
	import commands, re
	build = re.sub(r'/sources$', '', commands.getoutput('pwd'))
	build = re.sub(r'/tmp/work.*$', '', build)
	build = re.sub(r'/packages\.4g.*$', '', build)
	if re.search(r'/trunk/[^/]+/?$', build):
		return 'trunk'
	if re.search(r'/unstable$', build):
		return 'trunk'
	if re.search(r'/testing$', build):
		return 'testing'
	return re.sub(r'^.*/([^/]+/[^/]+)/[^/]+/?$', r'\1', build)

# end of get_branch

def get_tomorrow():
	import time
	return time.strftime('%Y%m%d', time.gmtime(time.time() + 3600*24))

# end of get_tomorrow
