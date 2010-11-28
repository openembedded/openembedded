require ${PN}.inc
PR = "r6"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_apps_calibrate.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_noncore_settings_mediummount.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_core_launcher.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_root.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_etc.tar.bz2 \
           file://nomax.patch;striplevel=3 \
           file://no-builtin-qss-startup.patch \
           file://kbdlocks-runtime.patch \
           file://restart-from-bindir.patch \
           file://server-pro-1.2.4.patch \
           file://firstuse-path.patch \
           file://force-firstuse-calibrate.patch \
          "
