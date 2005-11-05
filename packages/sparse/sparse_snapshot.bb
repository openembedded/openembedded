SECTION = "devel"
def get_snapshot_date(d):
	import bb
	cvsdate = bb.data.getVar('CVSDATE', d, 1)
	if not cvsdate:
		return ""
	y = cvsdate[0:4]
	m = cvsdate[4:6]
	d = cvsdate[6:8]
	return "%s-%s-%s" % (y, m, d)

DESCRIPTION = "Sparse is a semantic parser of source files: it's neither a \
compiler (although it could be used as a front-end for one) nor is it a \
preprocessor (although it contains as a part of it a preprocessing phase)."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PV = "0.0${CVSDATE}"
LICENSE = "OSL"
SRC_URI = "http://www.codemonkey.org.uk/projects/git-snapshots/sparse/sparse-${@get_snapshot_date(d)}.tar.gz \
	   file://compile.patch;patch=1 \
	   file://vars.patch;patch=1"
S = "${WORKDIR}/sparse-bk"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 check ${D}${bindir}/sparse
}
