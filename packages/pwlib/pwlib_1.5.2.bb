# pwlib .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

HOMEPAGE="http://www.openh323.org/docs/PWLib/"
DESCRIPTION="Portable Text and GUI C/C++ Class Libarary."
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"
LICENSE = "GPL"

SRC_URI="http://www.openh323.org/bin/${PN}_${PV}.tar.gz"
DEPENDS="openssl openldap"

inherit autotools

EXTRA_OECONF="--enable-ipv6 --disable-sasl --disable-sdl \
	      --disable-video --enable-plugins --with-plugins=oss"

S="${WORKDIR}/${PN}"

# Use openSSL

export OPENSSLFLAG=1
export OPENSSLDIR="${STAGING_LIBDIR}"
export OPENSSLLIBS="-lssl -lcrypt"
export MACHTYPE="x86"
export OSTYPE="linux"
export OSRELEASE="openembedded"

export CPLUS="${CXX}"

do_compile() {
	oe_runmake opt
}
