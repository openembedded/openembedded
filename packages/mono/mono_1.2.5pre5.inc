DESCRIPTION = "Mono Programming Language"
SECTION = "devel/mono"
LICENSE = "GPL LGPL X11"

# the md5 sum check is required because Novell does not version their pre release versions of mono
# if the md5sum check fails, contact cbrake on #oe
# checksums are stored in conf/checksums.ini
SRC_URI = "http://mono.ximian.com/monobuild/preview/sources/mono/mono-1.2.5.tar.bz2"

S = "${WORKDIR}/mono-1.2.5"

inherit autotools
EXTRA_OECONF = "--disable-mcs-build"
EXTRA_OECONF_arm = "--without-tls"
EXTRA_OECONF_mipsel = "--without-tls"

