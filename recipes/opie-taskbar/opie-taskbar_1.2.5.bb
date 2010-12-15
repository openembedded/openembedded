require ${PN}.inc
PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_apps_calibrate.tar.bz2;name=split_core_apps_calibrate \
           http://sources.openembedded.org/opie-1.2.5-split_noncore_settings_mediummount.tar.bz2;name=split_noncore_settings_mediummount \
           http://sources.openembedded.org/opie-1.2.5-split_core_launcher.tar.bz2;name=split_core_launcher \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
           http://sources.openembedded.org/opie-1.2.5-split_root.tar.bz2;name=split_root \
           http://sources.openembedded.org/opie-1.2.5-split_etc.tar.bz2;name=split_etc \
           file://nomax.patch;striplevel=3 \
           file://no-builtin-qss-startup-2.patch \
           file://kbdlocks-runtime.patch \
           file://restart-from-bindir.patch \
           file://server-pro-cvs.patch \
           file://firstuse-path.patch \
           file://force-firstuse-calibrate.patch \
           file://03opiesignal \
          "
SRC_URI[split_core_apps_calibrate.md5sum] = "ee5e06b781e92f01271d883f91f101b0"
SRC_URI[split_core_apps_calibrate.sha256sum] = "5e0164a195a166fd15451164edf8a44d8f3a9f81dcf3edc3a8975f24bd4b45b6"
SRC_URI[split_noncore_settings_mediummount.md5sum] = "5309e48475c721a9cda3c9a1701789cd"
SRC_URI[split_noncore_settings_mediummount.sha256sum] = "8554f74b00f5a3425a8a3d667eda5f0edd8f197bc33e78a59f3231eacd8c4f5c"
SRC_URI[split_core_launcher.md5sum] = "cd3708a2d074f108d81ffea590995725"
SRC_URI[split_core_launcher.sha256sum] = "fca1501398f1e4d0690455b145b17a68287de422592bca73c2afdf6762d021ce"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
SRC_URI[split_root.md5sum] = "47b2ea2c59ac34b3df21d43c53baaccd"
SRC_URI[split_root.sha256sum] = "0fb78622bb7ab459860aaa65fbea6145c45141195c1981164b40807b884628eb"
SRC_URI[split_etc.md5sum] = "74ef523ef12e242155bbb745072434d9"
SRC_URI[split_etc.sha256sum] = "eef55ea2248b4f45f3a07beb6012e431dd71d4eefa134d39cc50b4d194c53087"

do_install_append() {
	install -d ${D}${bindir} ${D}${sysconfdir}/apm/event.d/
	install -m 0755 ${WORKDIR}/03opiesignal ${D}${sysconfdir}/apm/event.d/
	install -m 0644 ${WORKDIR}/etc/opie_sysevents.conf ${D}${sysconfdir}/
}

