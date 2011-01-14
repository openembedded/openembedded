DESCRIPTION = "GNU Common C++"
HOMEPAGE = "http://freshmeat.net/projects/ccrtp"
LICENSE = "GPL"
DEPENDS = "commoncpp2"
PR = "r0"

SRC_URI = "ftp://ftp.gnu.org/gnu/ccrtp/ccrtp-${PV}.tar.gz;name=archive \
           file://configure.ac.patch"
SRC_URI[archive.md5sum] = "3410d2f43a6a28679bd091ed8b2ed228"
SRC_URI[archive.sha256sum] = "365feddd276c78104600204ae6db4e76c66036df1e5b905e855239daac6a2473"

inherit pkgconfig autotools

do_configure_prepend () {
        sed -i -e 's#COMMON_LIBPATH=`pkg-config --variable=libdir libccgnu2`#COMMON_LIBPATH=${STAGING_LIBDIR}#' configure.ac
}
