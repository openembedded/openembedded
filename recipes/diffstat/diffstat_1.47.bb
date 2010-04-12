DESCRIPTION = "diffstat reads the output of diff and displays a histogram of \
the insertions, deletions, and modifications per-file. It is useful for \
reviewing large, complex patch files."
HOMEPAGE = "http://invisible-island.net/diffstat/"
PRIORITY = "optional"
SECTION = "devel"

# NOTE: The upstream maintainer has a single 'diffstat.tar.gz' for the
# latest version of the package.  It could easily change out from under us.
# I'd rather rely on debian, and possible have the sources vanish, than risk
# the sources _changing_ underneith us. -CL
SRC_URI = "${DEBIAN_MIRROR}/main/d/diffstat/diffstat_${PV}.orig.tar.gz;name=archive \
	   ${DEBIAN_MIRROR}/main/d/diffstat/diffstat_${PV}-1.diff.gz;patch=1;name=patch"
S = "${WORKDIR}/diffstat-${PV}"

inherit autotools

do_configure () {
	if [ ! -e acinclude.m4 ]; then
		mv aclocal.m4 acinclude.m4
	fi
	autotools_do_configure
}

SRC_URI[archive.md5sum] = "c6d221ff4a032e1bbf227f5936a7841a"
SRC_URI[archive.sha256sum] = "0c398b749574b6bd54f5c5ac1d71118400cd54791e2f47a96a1ad07915d22832"
SRC_URI[patch.md5sum] = "b49f997897f5dfc2d2b8e0b6ea3df83c"
SRC_URI[patch.sha256sum] = "56dcebb128d401cd5608fcd77739b42f9cfc5af531d85822287f631ad6328dcd"
