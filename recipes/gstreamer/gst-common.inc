SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "LGPL"
HOMEPAGE = "http://www.gstreamer.net/"

DEFAULT_PREFERENCE = "-1"

inherit autotools gettext pkgconfig

# gstreamer uses AG_GST_GETTEXT which autotools.bbclass doesn't grep for
do_configure_prepend() {
	glib-gettextize --force --copy || true
}

OE_LT_RPATH_ALLOW = "any"
OE_LT_RPATH_ALLOW[export]="1"

