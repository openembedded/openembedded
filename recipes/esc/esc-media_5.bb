DESCRIPTION = "Media files to include on the Embedded Systems Conference workshop"
LICENSE="Various"

SRC_URI = "http://downloads.sourceforge.net/project/showoff/esc_media_files.tar.gz"
SRC_URI[md5sum] = "b75cbc0ce0dfcbd85de12e7fe9ecab8b"
SRC_URI[sha256sum] = "364f474a6356326c113d964885207d90741f2e95770b079d96fffc4295e62739"

S=${WORKDIR}/esc_media_files

do_install() {
    ESC_MEDIA="2009-obama-congress-speech.avi AlphaAnimal.license \
               AlphaAnimal.m4a BigBuckBunny_640x360.m4v bbb.flac \
               bbb.mp3 bbb.ogg davincieffect.aac gstreamer-logo.svg \
               sprc720.flv startup.wav"

    install -d ${D}${datadir}/esc-media
    for F in ${ESC_MEDIA} ; do
        install -m 0644 ${S}/${F} ${D}${datadir}/esc-media
    done
}

FILES_${PN} += "${datadir}/esc-media"

