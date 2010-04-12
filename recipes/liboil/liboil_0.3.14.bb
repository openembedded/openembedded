DESCRIPTION = "Liboil is a library of simple functions that are optimized for various CPUs."
HOMEPAGE = "http://liboil.freedesktop.org/"
LICENSE = "various"

# The configure script seems to have bogus checks, so let's not make it the default
DEFAULT_PREFERENCE = "-1"

DEPENDS = "glib-2.0"

SRC_URI = "http://liboil.freedesktop.org/download/${P}.tar.gz \
          "

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "7a9f719e50656b795c06c0167012a84f"
SRC_URI[sha256sum] = "a40c09db6ee24e03aa81f58329a57e45e55462a2e0f619b3796d4bf942c23f2f"
