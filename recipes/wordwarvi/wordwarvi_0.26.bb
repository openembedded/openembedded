DESCRIPTION = "Word war vi is a retro styled side scrolling shoot'em up arcade game"
HOMEPAGE = "http://wordwarvi.sourceforge.net/"
LICENSE = "GPLv2"
SECTION = "x/games"
PRIORITY = "optional"
PR = "r1"

DEPENDS = "portaudio-v19 libvorbis gtk+ glib-2.0"

SRC_URI = "http://sourceforge.net/projects/wordwarvi/files/wordwarvi/wordwarvi-0.26/wordwarvi-0.26.tar.gz \
           file://Makefile_cc.patch;apply=1 \
           file://audio_path.patch;apply=1 \
          "

EXTRA_OEMAKE = "CC='${CC} ${LDFLAGS}'"

do_install(){
	oe_runmake install "DESTDIR=${D}"
}

SRC_URI[md5sum] = "1c12a53839baf9c35c8671aa228043ab"
SRC_URI[sha256sum] = "96b0bd59749ae116cf33b03b04ef5535cd28ac360df14de96086ca11e289cd48"
