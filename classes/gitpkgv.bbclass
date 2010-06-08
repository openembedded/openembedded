# gitpkgv.bbclass provides a GITPKGV variable which is a sortable version
# with the format NN+GITHASH, to be used in PKGV, where
#
# NN equals the total number of revs up to SRCREV
# GITHASH is SRCREV's (full) hash
#
# gitpkgv.bbclass assumes the git repository has been cloned, and contains
# SRCREV. So ${GITPKGV} should never be used in PV, only in PKGV.
# It can handle SRCREV = ${AUTOREV}, as well as SRCREV = "<some fixed git hash>"
#
# use example:
#
# inherit gitpkgv
#
# PV = "1.0+git${SRCPV}"
# PKGV = "1.0+git${GITPKGV}"

GITPKGV = "${@get_git_pkgv(d)}"

def get_git_pkgv(d):
	import os
	import bb

	urls = bb.data.getVar('SRC_URI', d, 1).split()

	for url in urls:
		(type, host, path, user, pswd, parm) = bb.decodeurl(bb.data.expand(url, d))
		if type in ['git']:

			gitsrcname = '%s%s' % (host, path.replace('/', '.'))
			repodir = os.path.join(bb.data.expand('${GITDIR}', d), gitsrcname)
			rev = bb.fetch.get_srcrev(d).split('+')[1]

			cwd = os.getcwd()
			os.chdir(repodir)
			output = bb.fetch.runfetchcmd("git rev-list %s -- 2> /dev/null | wc -l" % rev, d, quiet=True)
			os.chdir(cwd)

			return "%s+%s" % (output.split()[0], rev)

	return "0+0"
