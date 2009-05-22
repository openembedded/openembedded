HOMEPAGE = "http://openh323.sourceforge.net/"
DESCRIPTION = "Portable Text and GUI C/C++ Class Libarary."
LICENSE = "GPL"
DEPENDS = "openssl openldap"

INC_PR = "r1"

# Somebody should teach these people about naming tarballs ;-)
MIN_VER ?= "1"
SHRT_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}_${@bb.data.getVar('PV',d,1).split('.')[1]}_${@bb.data.getVar('PV',d,1).split('.')[1]}"
SRC_URI = "http://www.voxgratia.org/releases/${PN}-v1_${SHRT_VER}-${MIN_VER}src.tar.gz"

inherit autotools

EXTRA_OECONF="--enable-ipv6 --disable-sasl --disable-sdl \
	      --disable-video --enable-plugins --with-plugins=oss"

# Use openSSL

export OPENSSLFLAG="1"
export OPENSSLDIR="${STAGING_LIBDIR}"
export OPENSSLLIBS="-lssl -lcrypt"
export MACHTYPE="x86"
export OSTYPE="linux"
export OSRELEASE="openembedded"

export CPLUS="${CXX}"

do_compile() {
	oe_runmake opt
}
