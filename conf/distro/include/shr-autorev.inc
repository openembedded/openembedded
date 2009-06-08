# SHR conf file

# We need to override some machine stuff as well; include the machine-
# specific file here (if it exists).
include conf/distro/include/shr-${MACHINE}.conf

# Nail down some SRCREV's for the kernels.  There is a real potential problem
# here, in that git hashes are hashes, not incrementing version numbers.  Thus
# we need to have something else in the kernel version string that gets bumped
# with each change.  So if you change one of these, go to the kernel recipe
# and bump the OEV value up as well.
SRCREV_pn-linux-eten = "df9715883efa3e6a88866813168fabb1c16b0b7a"
SRCREV_pn-linux-openmoko-shr-devel = "f16c3431a1a7510eb3504ec5d96677dd0fac4cd6"

PREFERRED_VERSION_shared-mime-info = "0.51"
PREFERRED_VERSION_navit = "0.1.0+svnrev${SRCREV}"
PREFERRED_VERSION_libosip2 = "2.2.2"
PREFERRED_VERSION_udev = "124"
PREFERRED_VERSION_midori = "0.1.2"
PREFERRED_VERSION_obexftp = "0.22"
PREFERRED_VERSION_glib-2.0 = "2.18.3"
PREFERRED_VERSION_mokomaze = "0.5.1"
PREFERRED_VERSION_calc = "0.0.1"
PREFERRED_VERSION_dbus = "1.2.14"
PREFERRED_VERSION_dbus-glib = "0.78"
PREFERRED_VERSION_bluez4 = "4.39"
PREFERRED_VERSION_connman = "0.19"


#FSO stuff
SRCREV_pn-frameworkd = "360c068b204d7af5b0af39477a25f2e45cb62164"
SRCREV_pn-frameworkd-config-shr = "${AUTOREV}"
SRCREV_pn-frameworkd-config-shr_FSO_REV = "360c068b204d7af5b0af39477a25f2e45cb62164"
SRCREV_pn-frameworkd-config-shr_SHR_REV = "e63d16be7d5a2e900fad1998b4e44985179b44f3"
SRCREV_pn-fso-gpsd = "${AUTOREV}"
SRCREV_pn-fso-sounds = "${AUTOREV}"
SRCREV_pn-gsm0710muxd = "${AUTOREV}"
SRCREV_pn-gsmd2 = "${AUTOREV}"
SRCREV_pn-illume-theme-freesmartphone = "${AUTOREV}"
SRCREV_pn-mickeydbus = "${AUTOREV}"
SRCREV_pn-mickeyterm = "${AUTOREV}"
SRCREV_pn-python-pytrc = "${AUTOREV}"
SRCREV_pn-zhone = "${AUTOREV}"

#SHR stuff
SRCREV_pn-libhito = "${AUTOREV}"
SRCREV_pn-neod = "${AUTOREV}"
SRCREV_pn-shr-settings = "29cc9e80246082f21899bd732bf649d33895c26d"
SRCREV_pn-shr-theme                  = "e63d16be7d5a2e900fad1998b4e44985179b44f3"
SRCREV_pn-ophonekitd                 = "e63d16be7d5a2e900fad1998b4e44985179b44f3"
SRCREV_pn-shr-messages               = "e63d16be7d5a2e900fad1998b4e44985179b44f3"
SRCREV_pn-shr-contacts               = "e63d16be7d5a2e900fad1998b4e44985179b44f3"
SRCREV_pn-shr-dialer                 = "e63d16be7d5a2e900fad1998b4e44985179b44f3"
SRCREV_pn-libframeworkd-phonegui     = "e63d16be7d5a2e900fad1998b4e44985179b44f3"
SRCREV_pn-libframeworkd-phonegui-efl = "e63d16be7d5a2e900fad1998b4e44985179b44f3"
SRCREV_pn-libframeworkd-phonegui-gtk = "${AUTOREV}"
SRCREV_pn-libframeworkd-glib = "9765f6989d09d8f9b8676e1ef7e2501fe67fbdbc"
SRCREV_pn-pyphonelog = "${AUTOREV}"
SRCREV_pn-shr-theme-brave = "${AUTOREV}"
SRCREV_pn-shr-splash = "${AUTOREV}"
SRCREV_pn-shr-splash-theme-simple = "${AUTOREV}"
SRCREV_pn-shr-splash-theme-dontpanic = "${AUTOREV}"
SRCREV_pn-shr-splash-theme-handy = "${AUTOREV}"

#General stuff
EFL_SRCREV = "40567"
SRCREV_pn-python-elementary = "40756"
SRCREV_pn-e-wm-config-illume-shr = "${AUTOREV}"
SRCREV_pn-e-wm-sysactions-shr = "${AUTOREV}"
SRCREV_pn-e-wm-theme-illume-shr = "${AUTOREV}"
SRCREV_pn-e-wm-menu-shr = "${AUTOREV}"
SRCREV_pn-e-wm-illume-dict-pl = "${AUTOREV}"
SRCREV_pn-etk-theme-shr = "${AUTOREV}"
SRCREV_pn-libgee = "780e79f624419b1911de422cbd72f289d23cd9af"

SRCREV_pn-navit = "2308"
SRCREV_pn-omview = "${AUTOREV}"
SRCREV_pn-pythm = "${AUTOREV}"
SRCREV_pn-omoney = "29"
SRCREV_pn-enotes = "19"
SRCREV_pn-ebrainy = "${AUTOREV}"
SRCREV_pn-boost-signals2 = "52299"
SRCREV_pn-dbus-c++-native = "${AUTOREV}"
SRCREV_pn-dbus-c++ = "${AUTOREV}"
SRCREV_pn-openmoocow = "${AUTOREV}"
SRCREV_pn-libmokoui2 = "4695"
PREFERRED_VERSION_calc = "0.0.1"
#pin shr-config due to gnome bug 579803 (requires vala > 0.7.1)
SRCREV_pn-shr-config = "9b59390d265805b68ea10136fa03fa67713f1275"
SRCREV_pn-libeflvala = "${AUTOREV}"
SRCREV_pn-alsa-scenarii-shr = "${AUTOREV}"
