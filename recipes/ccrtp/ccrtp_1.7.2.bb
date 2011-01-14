DESCRIPTION = "GNU Common C++"
HOMEPAGE = "http://freshmeat.net/projects/ccrtp"
LICENSE = "GPL"
DEPENDS = "commoncpp2"
PR = "r0"

SRC_URI = "ftp://ftp.gnu.org/gnu/ccrtp/ccrtp-${PV}.tar.gz;name=archive \
           file://configure.ac.patch"
SRC_URI[archive.md5sum] = "0c2edb048c510ba7cd172e833aea8ac5"
SRC_URI[archive.sha256sum] = "9e7facfac942f401a4527268905b13fe68aa50ff751fa64b825190015c2ae7ef"

inherit pkgconfig autotools

do_configure_prepend () {
        sed -i -e 's#COMMON_LIBPATH=`pkg-config --variable=libdir libccgnu2`#COMMON_LIBPATH=${STAGING_LIBDIR}#' configure.ac
}
