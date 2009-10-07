require vala.inc
inherit native

PR = "r1"

DEPENDS = "glib-2.0-native"

SRC_URI = "\
                  ${GNOME_MIRROR}/vala/0.7/vala-${PV}.tar.bz2 \
                  file://0003-Fix-delegate-variables-in-GObject-creation-methods.patch;patch=1 \
                  file://0005-Fix-return-type-of-closure-unref-function.patch;patch=1 \
                  file://0010-D-Bus-Fix-marshalling-of-GLib.Value-parameters.patch;patch=1 \
                  file://0014-GError-Fix-error-propagation-in-creation-methods.patch;patch=1 \
                  file://0018-glib-2.0-Fix-g_regex_get_pattern-binding.patch;patch=1 \
                  file://0001-Fix-generated-code-for-stack-allocated-arrays.patch;patch=1 \
                  file://0001-Fix-memory-management-for-closures-used-as-signal-ha.patch;patch=1 \
                  file://0001-GAsync-Fix-async-methods-with-delegate-parameters.patch;patch=1 \
                  file://0001-GAsync-Fix-connecting-signal-handlers-in-async-meth.patch;patch=1 \
                  "
