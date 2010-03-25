DESCRIPTION = "A protocol library to access an iPhone or iPod Touch in Linux"
LICENSE = "GPLv2/LGPLv2.1"

DEPENDS = "libplist swig usbmuxd glib-2.0 gnutls libgcrypt"

inherit autotools

SRC_URI = "http://cloud.github.com/downloads/MattColyer/libiphone/libimobiledevice-${PV}.tar.bz2;name=archive"
SRC_URI[archive.md5sum] = "c86584080eae622c6da1782fc9bb39aa"
SRC_URI[archive.sha256sum] = "1620ed57441f1fb6a5f62ab4579213a0b1193f301a4c198ac1d013dd62eff480"

# needed for configure
export HOST_SYS
export BUILD_SYS
export STAGING_LIBDIR
export STAGING_INCDIR

EXTRA_OECONF = " --without-swig "

do_configure_prepend() {
	sed -i -e /SWIG_PYTHON/d ${S}/configure.ac
}

