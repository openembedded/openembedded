SECTION = "devel"
def get_snapshot_date(d):
	import bb
	srcdate = bb.data.getVar('SRCDATE', d, 1)
	if not srcdate:
		return ""
	y = srcdate[0:4]
	m = srcdate[4:6]
	d = srcdate[6:8]
	return "%s-%s-%s" % (y, m, d)

DESCRIPTION = "Sparse is a semantic parser of source files: it's neither a \
compiler (although it could be used as a front-end for one) nor is it a \
preprocessor (although it contains as a part of it a preprocessing phase)."
PV = "0.0+${SRCDATE}"
LICENSE = "OSL"
SRC_URI = "http://www.codemonkey.org.uk/projects/git-snapshots/sparse/sparse-${@get_snapshot_date(d)}.tar.gz \
	   file://compile.patch;patch=1 \
	   file://vars.patch;patch=1"
S = "${WORKDIR}/sparse-bk"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 check ${D}${bindir}/sparse
}

SRC_URI[md5sum] = "6016c8271e4b8640d8cd97719b120e59"
SRC_URI[sha256sum] = "3dea88d313c565e84fea5638da30894fea4e63e8d618e2a86f6e231b3dec6182"
