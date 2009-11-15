DESCRIPTION = "Mono Programming Language"
SECTION = "devel/mono"
LICENSE = "GPL LGPL X11"

SRCREV = "87352"
SRC_URI = "svn://anonsvn.mono-project.com/source/trunk/;module=mcs;rev=${SRCREV};name=mcs \
	svn://anonsvn.mono-project.com/source/trunk/;module=mono;rev=${SRCREV};name=mono "
SRCREV_FORMAT = "rmono"

PV = "1.2.5.1+svnr${SRCPV}"
S = "${WORKDIR}/mono"

inherit autotools
EXTRA_OECONF_arm = "--without-tls"
EXTRA_OECONF_mipsel = "--without-tls"

