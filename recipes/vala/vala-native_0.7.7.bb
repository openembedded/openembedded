require vala.inc
inherit native

PR = "r1"

DEPENDS = "glib-2.0-native"

SRC_URI = "\
                  ${GNOME_MIRROR}/vala/0.7/vala-${PV}.tar.bz2 \
                  file://0003-Fix-delegate-variables-in-GObject-creation-methods.patch;patch=1 \
                  file://0005-Fix-return-type-of-closure-unref-function.patch;patch=1 \
#                  file://0010-D-Bus-Fix-marshalling-of-GLib.Value-parameters.patch;patch=1 \
                  file://0014-GError-Fix-error-propagation-in-creation-methods.patch;patch=1 \
                  file://0018-glib-2.0-Fix-g_regex_get_pattern-binding.patch;patch=1 \
                  "
