require qte-common_2.3.10.inc
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/qte-${PV}"

SRC_URI = "http://ewi546.ewi.utwente.nl/mirror/hrw-oe-sources/qt-embedded-2.3.10-snapshot-20060120.tar.gz \ 
   	   file://qpe.patch;patch=1 \
	   file://vt-switch.patch;patch=1 \
	   file://daemonize.patch;patch=1 \
	   file://no-moc.patch;patch=1 \
	   file://gcc3.patch;patch=1 \
	   file://gcc4.patch;patch=1 \
	   file://c700-hardware.patch;patch=1 \
	   file://encoding.patch;patch=1 \
	   file://fix-qgfxraster.patch;patch=1 \
	   file://qt-visibility.patch;patch=1 \
	   file://simpad.patch;patch=1 \
	   file://handhelds.patch;patch=1 \
	   file://qiconview-speed.patch;patch=1 \
	   file://qtabbar.patch;patch=1 \
	   file://qte-fix-iconsize.patch;patch=1 \
	   file://fix-linuxfb-setmode.patch;patch=1 \
	   file://fix-linuxfb-offscreenoverflow.patch;patch=1 \
	   file://fix-qscreen-sync.patch;patch=1 \
	   file://improve-calibration-r0.patch;patch=1 \
	   file://key.patch;patch=1 \
	   file://bidimetrics.patch;patch=5 \
	   file://simpad-defaultkbd.patch;patch=1 \
	   file://fix-errno-exception-spec.patch;patch=1 \
	   file://sharp_char.h \
	   file://switches.h "

SRC_URI_append_simpad       = "file://devfs.patch;patch=1 "
SRC_URI_append_c7x0         = "file://kernel-keymap.patch;patch=1;pnum=0 file://kernel-keymap-corgi.patch;patch=1 \
                               file://c7x0-w100-accel.patch;patch=1 file://suspend-resume-hooks.patch;patch=1 "
SRC_URI_append_spitz        = "file://kernel-keymap.patch;patch=1;pnum=0 file://kernel-keymap-corgi.patch;patch=1 \                 
                               file://kernel-keymap-CXK.patch;patch=1 "
SRC_URI_append_akita        = "file://kernel-keymap.patch;patch=1;pnum=0 file://kernel-keymap-corgi.patch;patch=1 \                 
                               file://kernel-keymap-CXK.patch;patch=1 "
SRC_URI_append_poodle       = "file://kernel-keymap.patch;patch=1;pnum=0 "
SRC_URI_append_a780         = "file://kernel-keymap.patch;patch=1;pnum=0 "
SRC_URI_append_e680         = "file://kernel-keymap.patch;patch=1;pnum=0 "
SRC_URI_append_tosa         = "file://kernel-keymap.patch;patch=1;pnum=0 file://kernel-keymap-tosa.patch;patch=1 "
SRC_URI_append_jornada7xx   = "file://kernel-keymap.patch;patch=1;pnum=0 file://ipaq_sound_fix.patch;patch=1 "
SRC_URI_append_jornada56x   = "file://kernel-keymap.patch;patch=1;pnum=0 file://ipaq_sound_fix.patch;patch=1 "
SRC_URI_append_mnci         = "file://devfs.patch;patch=1 \
                               file://mnci.patch;patch=1 \
                               file://mnci-touchscreen.patch;patch=1 \
                               file://qkeyboard_qws.h \
                               file://qkeyboard_qws.cpp "
SRC_URI_append_h3600        = "file://ipaq-keyboard.patch;patch=1 file://ipaq_sound_fix.patch;patch=1 "
SRC_URI_append_h3900        = "file://ipaq-keyboard.patch;patch=1 file://ipaq_sound_fix.patch;patch=1 "
SRC_URI_append_h1910        = "file://ipaq-keyboard.patch;patch=1 file://ipaq_sound_fix.patch;patch=1 "

S = "${WORKDIR}/qt-2.3.10-snapshot-20060120"
export QTDIR = "${S}"

do_stage_append() {
	install -m 0644 src/kernel/qsnoopdata_qws_p.h ${STAGING_DIR}/${HOST_SYS}/qt2/include/
}
