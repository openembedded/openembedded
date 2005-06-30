DESCRIPTION = "Themed style"
SECTION = "opie/styles"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "theme"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/styles/libtheme.so*
do_install() {
	install -d ${D}${palmtopdir}/plugins/styles/pixmaps/
	install -d ${D}${palmtopdir}/plugins/styles/themes/
	for t in cleannsimple GradE8 ixpe luna
	do
		install -d ${D}${palmtopdir}/plugins/styles/pixmaps/$t/
		for f in ../styles/pixmaps/$t/*
		do
		   [ -f $f ] && install -m 0644 $f ${D}${palmtopdir}/plugins/styles/pixmaps/$t/
		done
		install -m 0644 ../styles/themes/$t.themerc ${D}${palmtopdir}/plugins/styles/themes/
	done
	for t in lumonmarble lumonwave
	do
		install -d ${D}${palmtopdir}/plugins/styles/pixmaps/lumon/
		for f in ../styles/pixmaps/lumon/*
		do
		   [ -f $f ] && install -m 0644 $f ${D}${palmtopdir}/plugins/styles/pixmaps/lumon/
		done
		install -m 0644 ../styles/themes/$t.themerc ${D}${palmtopdir}/plugins/styles/themes/
	done
}

PACKAGES = " opie-theme-cleannsimple opie-theme-grade8 opie-theme-ixpe opie-theme-lumonmarble opie-theme-lumonwave opie-theme-luna opie-theme "

FILES_opie-theme = " ${palmtopdir}/plugins/styles/libtheme.so*"
FILES_opie-theme-cleannsimple = " ${palmtopdir}/plugins/styles/themes/cleannsimple.themerc ${palmtopdir}/plugins/styles/pixmaps/cleannsimple/*.png"
FILES_opie-theme-grade8 = " ${palmtopdir}/plugins/styles/themes/GradE8.themerc ${palmtopdir}/plugins/styles/pixmaps/GradE8/*.png"
FILES_opie-theme-ixpe = " ${palmtopdir}/plugins/styles/themes/ixpe.themerc ${palmtopdir}/plugins/styles/pixmaps/ixpe/*.png"
FILES_opie-theme-lumonmarble = " ${palmtopdir}/plugins/styles/themes/lumonmarble.themerc ${palmtopdir}/plugins/styles/pixmaps/lumon/arrowdown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/arrowleft.png ${palmtopdir}/plugins/styles/pixmaps/lumon/arrowright.png ${palmtopdir}/plugins/styles/pixmaps/lumon/arrowup.png ${palmtopdir}/plugins/styles/pixmaps/lumon/backgroundwhitemarble.png ${palmtopdir}/plugins/styles/pixmaps/lumon/backgroundbluemarble.png ${palmtopdir}/plugins/styles/pixmaps/lumon/button.png ${palmtopdir}/plugins/styles/pixmaps/lumon/buttonborder.png ${palmtopdir}/plugins/styles/pixmaps/lumon/buttonborderdown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/buttondown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/checkbox.png ${palmtopdir}/plugins/styles/pixmaps/lumon/checkboxdown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/hscrollgroove.png ${palmtopdir}/plugins/styles/pixmaps/lumon/menubar.png ${palmtopdir}/plugins/styles/pixmaps/lumon/menuitemdown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/radio.png ${palmtopdir}/plugins/styles/pixmaps/lumon/radiodown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/scrollbutton.png ${palmtopdir}/plugins/styles/pixmaps/lumon/sunkenarrowdown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/sunkenarrowleft.png ${palmtopdir}/plugins/styles/pixmaps/lumon/sunkenarrowright.png ${palmtopdir}/plugins/styles/pixmaps/lumon/sunkenarrowup.png ${palmtopdir}/plugins/styles/pixmaps/lumon/tab.png ${palmtopdir}/plugins/styles/pixmaps/lumon/tabdown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/vscrollgroove.png"
FILES_opie-theme-lumonwave = " ${palmtopdir}/plugins/styles/themes/lumonwave.themerc ${palmtopdir}/plugins/styles/pixmaps/lumon/arrowdown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/arrowleft.png ${palmtopdir}/plugins/styles/pixmaps/lumon/arrowright.png ${palmtopdir}/plugins/styles/pixmaps/lumon/arrowup.png ${palmtopdir}/plugins/styles/pixmaps/lumon/backgroundwave.png ${palmtopdir}/plugins/styles/pixmaps/lumon/backgroundwaveblue.png ${palmtopdir}/plugins/styles/pixmaps/lumon/button.png ${palmtopdir}/plugins/styles/pixmaps/lumon/buttonborder.png ${palmtopdir}/plugins/styles/pixmaps/lumon/buttonborderdown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/buttondown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/checkbox.png ${palmtopdir}/plugins/styles/pixmaps/lumon/checkboxdown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/hscrollgroove.png ${palmtopdir}/plugins/styles/pixmaps/lumon/menubar.png ${palmtopdir}/plugins/styles/pixmaps/lumon/menuitemdown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/radio.png ${palmtopdir}/plugins/styles/pixmaps/lumon/radiodown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/scrollbutton.png ${palmtopdir}/plugins/styles/pixmaps/lumon/splitter.png ${palmtopdir}/plugins/styles/pixmaps/lumon/sunkenarrowdown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/sunkenarrowleft.png ${palmtopdir}/plugins/styles/pixmaps/lumon/sunkenarrowright.png ${palmtopdir}/plugins/styles/pixmaps/lumon/sunkenarrowup.png ${palmtopdir}/plugins/styles/pixmaps/lumon/tab.png ${palmtopdir}/plugins/styles/pixmaps/lumon/tabdown.png ${palmtopdir}/plugins/styles/pixmaps/lumon/vscrollgroove.png"
FILES_opie-theme-luna = " ${palmtopdir}/plugins/styles/themes/luna.themerc ${palmtopdir}/plugins/styles/pixmaps/luna/*.png"
