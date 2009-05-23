# SHR conf file

## This file, contrary to its name, is really the equivalent of the
## distro conf file for SHR.

# Since we're not a distro yet, we have to manually add "shr" as an
# override -- this line should be removed when SHR becomes a distro.
OVERRIDES .= ":shr"

# We need to override some machine stuff as well; include the machine-
# specific file here (if it exists).
include conf/distro/include/shr-${MACHINE}.conf

DISTRO_INITSCRIPTS = "initscripts-shr"
DISTRO_DEV_MANAGER = "udev"

# Nail down some SRCREV's for the kernels.  There is a real potential problem
# here, in that git hashes are hashes, not incrementing version numbers.  Thus
# we need to have something else in the kernel version string that gets bumped
# with each change.  So if you change one of these, go to the kernel recipe
# and bump the OEV value up as well.
SRCREV_pn-linux-eten = "df9715883efa3e6a88866813168fabb1c16b0b7a"
SRCREV_pn-linux-openmoko-2.6.28 = "81c61a7d1abb03aecd13f5395aba355e996a1641"

PREFERRED_PROVIDER_frameworkd-config = "frameworkd-config-shr"
PREFERRED_PROVIDER_frameworkd = "frameworkd"
PREFERRED_PROVIDER_gpsd = "fso-gpsd"

PREFERRED_VERSION_shared-mime-info = "0.51"
PREFERRED_VERSION_navit = "0.1.0+svnrev${SRCREV}"
PREFERRED_VERSION_libosip2 = "2.2.2"
PREFERRED_VERSION_udev = "124"
PREFERRED_VERSION_midori = "0.1.2"
PREFERRED_VERSION_obexftp = "0.22"
PREFERRED_VERSION_glib-2.0 = "2.18.3"
PREFERRED_VERSION_mokomaze = "0.2.3"
PREFERRED_PROVIDER_e-wm-menu = "e-wm-menu-shr"

#FSO stuff
SRCREV_pn-frameworkd = "516f48762ab7afa4e4702a0ba01bc0a004ae4c60"
SRCREV_pn-frameworkd-config-shr = "${AUTOREV}"
SRCREV_pn-frameworkd-config-shr_FSO_REV = "516f48762ab7afa4e4702a0ba01bc0a004ae4c60"
SRCREV_pn-frameworkd-config-shr_SHR_REV = "fddd6e828e791f4ea69f89f15a8cdd7b1d5b540e"
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
PREFERRED_PROVIDER_virtual/shr-splash-theme = "shr-splash-theme-simple"
SRCREV_pn-libhito = "${AUTOREV}"
SRCREV_pn-neod = "${AUTOREV}"
SRCREV_pn-shr-settings = "a3e5e3430cf3803e21107e8e83aefdbcab27f56a"
SRCREV_pn-shr-theme                  = "9855b6b1a9cbe0c2b8765d21b4d11d807c2b3e46"
SRCREV_pn-ophonekitd                 = "9855b6b1a9cbe0c2b8765d21b4d11d807c2b3e46"
SRCREV_pn-shr-messages               = "9855b6b1a9cbe0c2b8765d21b4d11d807c2b3e46"
SRCREV_pn-shr-contacts               = "9855b6b1a9cbe0c2b8765d21b4d11d807c2b3e46"
SRCREV_pn-shr-dialer                 = "9855b6b1a9cbe0c2b8765d21b4d11d807c2b3e46"
SRCREV_pn-libframeworkd-phonegui     = "9855b6b1a9cbe0c2b8765d21b4d11d807c2b3e46"
SRCREV_pn-libframeworkd-phonegui-efl = "9855b6b1a9cbe0c2b8765d21b4d11d807c2b3e46"
SRCREV_pn-libframeworkd-phonegui-gtk = "${AUTOREV}"
SRCREV_pn-libframeworkd-glib = "9765f6989d09d8f9b8676e1ef7e2501fe67fbdbc"
SRCREV_pn-pyphonelog = "${AUTOREV}"
SRCREV_pn-shr-theme-brave = "${AUTOREV}"
SRCREV_pn-shr-splash = "${AUTOREV}"
SRCREV_pn-shr-splash-theme-simple = "${AUTOREV}"
SRCREV_pn-shr-splash-theme-dontpanic = "${AUTOREV}"

#General stuff
EFL_SRCREV = "39827"
SRCREV_pn-e-wm-config-illume-shr = "${AUTOREV}"
SRCREV_pn-e-wm-sysactions-shr = "${AUTOREV}"
SRCREV_pn-e-wm-theme-illume-shr = "${AUTOREV}"
SRCREV_pn-e-wm-menu-shr = "${AUTOREV}"

SRCREV_pn-navit = "2198"
SRCREV_pn-python-elementary = "39834"
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
