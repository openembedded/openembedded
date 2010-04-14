DESCRIPTION = "The Debian Almquist Shell is a POSIX compliant shell that is much smaller than 'bash'."
PROVIDES = "virtual/sh"
LICENSE = "BSD GPL"

SRC_URI = "http://ftp.debian.org/debian/pool/main/d/dash/dash_${PV}.orig.tar.gz;name=archive \
	http://ftp.debian.org/debian/pool/main/d/dash/dash_${PV}-2.3.diff.gz;patch=1;name=patch \
	file://makefile-build-cc.diff;patch=1"

SRC_URI[archive.md5sum] = "7ac832b440b91f5a52cf8eb68e172616"
SRC_URI[archive.sha256sum] = "1c6717a1014c73aa16bc78a4767f1e00b40ff2a01a6c2cf2cce9a5335c24493f"
SRC_URI[patch.md5sum] = "be9cf0b148f4127d06cede66241175c0"
SRC_URI[patch.sha256sum] = "afa02603f39a9557c65f88702f41190fa69e41ebe5d7729b4a52ab04573539c5"

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
