DESCRIPTION = "The Debian Almquist Shell is a POSIX compliant shell that is much smaller than 'bash'."
PROVIDES = "virtual/sh"
LICENSE = "BSD GPL"

SRC_URI = "http://ftp.debian.org/debian/pool/main/d/dash/dash_${PV}.orig.tar.gz \
	http://ftp.debian.org/debian/pool/main/d/dash/dash_${PV}-4.diff.gz;patch=1 \
	file://makefile-build-cc.diff;patch=1"
	
inherit autotools

bindir = "/bin"
PREFIX="${bindir}"

# dont use update-alternatives class because since we are dealing with /bin/sh
# we need to do the remove in pkg_prerm where the /bin/sh link still points
# to something (postrm is a shell script)

ALTERNATIVE_NAME = "sh"
ALTERNATIVE_PATH = "${bindir}/dash"
ALTERNATIVE_PRIORITY = "10"
ALTERNATIVE_LINK = "${bindir}/${ALTERNATIVE_NAME}"

pkg_postinst() {
update-alternatives --install ${ALTERNATIVE_LINK} ${ALTERNATIVE_NAME} ${ALTERNATIVE_PATH} ${ALTERNATIVE_PRIORITY}
}

pkg_prerm() {
update-alternatives --remove ${ALTERNATIVE_NAME} ${ALTERNATIVE_PATH}
}
