DESCRIPTION = "GNU Common C++"
HOMEPAGE = "http://freshmeat.net/projects/ccrtp"
LICENSE = "GPL"
DEPENDS = "commoncpp2"
PR = "r0"

SRC_URI = "ftp://ftp.gnu.org/gnu/ccrtp/ccrtp-${PV}.tar.gz;name=archive \
           file://configure.ac.patch;patch=1"
SRC_URI[archive.md5sum] = "eb86cd2ac06af27ea60b1a349122605c"
SRC_URI[archive.sha256sum] = "923cd26ffc43903ef33704e46fd57f659c3ad01554927fe323635a73082d56ae"

inherit pkgconfig autotools_stage

do_configure_prepend () {
        sed -i -e 's#COMMON_LIBPATH=`pkg-config --variable=libdir libccgnu2`#COMMON_LIBPATH=${STAGING_LIBDIR}#' configure.ac
}
