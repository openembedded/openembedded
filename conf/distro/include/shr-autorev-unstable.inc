
# FSO stuff
# we always want fso-autorev for unstable
require conf/distro/include/fso-autorev.inc

SRCREV_pn-fsoraw = "${AUTOREV}"

# SHR stuff
SRCREV_pn-shr-settings = "${AUTOREV}"
SRCREV_pn-shr-theme = "${AUTOREV}"
SRCREV_pn-shr-theme-gtk-e17lookalike = "${AUTOREV}"
SRCREV_pn-libframeworkd-glib = "${AUTOREV}"
SRCREV_pn-ophonekitd = "${AUTOREV}"
SRCREV_pn-libmodulo = "${AUTOREV}"
SRCREV_pn-ophonekitd-vala = "${AUTOREV}"
SRCREV_pn-shr-messages = "${AUTOREV}"
SRCREV_pn-shr-contacts = "${AUTOREV}"
SRCREV_pn-shr-dialer = "${AUTOREV}"
SRCREV_pn-libframeworkd-phonegui-efl = "${AUTOREV}"
SRCREV_pn-libframeworkd-phonegui-efl2 = "${AUTOREV}"
SRCREV_pn-libframeworkd-phonegui = "${AUTOREV}"
SRCREV_pn-libhito = "${AUTOREV}"
SRCREV_pn-neod = "${AUTOREV}"
SRCREV_pn-libframeworkd-phonegui-gtk = "${AUTOREV}"
SRCREV_pn-libframeworkd-phonegui-gtk2 = "${AUTOREV}"
#pin shr-config due to gnome bug 579803 (requires vala > 0.7.1)
#SRCREV_pn-shr-config = "9b59390d265805b68ea10136fa03fa67713f1275"

#EFL_SRCREV = "40567"
#SRCREV_pn-python-elementary = "40756"

# KERNEL
SRCREV_pn-linux-openmoko-shr-devel = "${AUTOREV}"
SRCREV_pn-linux-eten = "df9715883efa3e6a88866813168fabb1c16b0b7a"

# other stuff
SRCREV_pn-openmoocow = "${AUTOREV}"
SRCREV_pn-libmokoui2 = "4695"
SRCREV_pn-intone = "${AUTOREV}"
SRCREV_pn-libgee = "${AUTOREV}"

#PREFERRED_VERSION_fakeroot = "1.12.1"
#PREFERRED_VERSION_fakeroot-native = "1.12.1"

SRCREV_pn-dbus-c++-native = "${AUTOREV}"
SRCREV_pn-dbus-c++ = "${AUTOREV}"
