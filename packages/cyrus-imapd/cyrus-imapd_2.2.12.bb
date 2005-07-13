SECTION = "console/network"
DEPENDS = "cyrus-sasl db"
LICENSE = "BSD"
PR = "r2"
DEPENDS += "install-native"

SRC_URI = "ftp://ftp.andrew.cmu.edu/pub/cyrus-mail/cyrus-imapd-${PV}.tar.gz \
           file://autotools.patch;patch=1 \
           file://tail.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-auth=unix \
		--without-perl \
		--without-snmp"

FILES_${PN} += "${prefix}/cyrus/bin"

# Target only, the db4 headers are in include/db4, so *prepend* this
# directory to the search path
TARGET_CPPFLAGS =+ "-I${STAGING_DIR}/${TARGET_SYS}/include/db4"

# All, lib/foo.c includes <config.h> from the top level directory and
# is natively compiled
BUILD_CPPFLAGS += " -I${S} -I${S}/et"
