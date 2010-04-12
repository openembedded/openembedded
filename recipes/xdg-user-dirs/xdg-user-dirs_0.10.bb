DESCRIPTION = "xdg-user-dirs is a tool to help manage user directories like the desktop folder and the music folder"
SRC_URI = "http://user-dirs.freedesktop.org/releases/xdg-user-dirs-0.10.tar.gz \
           file://configurefix.patch;patch=1 "
PR = "r1"

inherit autotools_stage

do_install_append () {
	install -d ${D}${sysconfdir}/skel/.config/
	mv ${D}${sysconfdir}/xdg/user-dirs.defaults ${D}${sysconfdir}/skel/.config/user-dirs.dirs
}

SRC_URI[md5sum] = "6873f49ea7f568743621ed1e05e52dab"
SRC_URI[sha256sum] = "169978c677db5c498f485e9896cd0ababae6b3a9d0bf640ffa719d5af2abca46"
