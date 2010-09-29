DESCRIPTION = "Opie Launcher and Taskbar"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "qpe"

S = "${WORKDIR}/pics"

inherit opie

# Wallpaper and welcome splash
PIXMAP_SIZE 		= ""
PIXMAP_SIZE_c7x0 	= "-640x480"
PIXMAP_SIZE_spitz	= "-640x480"
PIXMAP_SIZE_akita	= "-640x480"
PIXMAP_SIZE_tosa 	= "-480x640"
PIXMAP_SIZE_simpad 	= "-800x600"
PIXMAP_SIZE_asus730     = "-480x640"
PIXMAP_SIZE_htcuniversal= "-480x640"
PIXMAP_SIZE_hx4700      = "-480x640"
PIXMAP_SIZE_palmz31     = "-160x160"
PIXMAP_SIZE_palmz71     = "-320x320"
PIXMAP_SIZE_palmz72     = "-320x320"
PIXMAP_SIZE_palmt650    = "-320x320"
PIXMAP_SIZE_palmt680    = "-320x320"
PIXMAP_SIZE_palmt3      = "-320x480"
PIXMAP_SIZE_palmt5      = "-320x480"
PIXMAP_SIZE_palmtx      = "-320x480"
PIXMAP_SIZE_palmld      = "-320x480"

do_configure() {
        :
}

do_install() {
	install -d ${D}${palmtopdir}/pics/launcher
	
	install -m 0644 ${WORKDIR}/pics/launcher/firstuse.jpg ${D}${palmtopdir}/pics/launcher/firstuse-240x320.jpg
	install -m 0644 ${WORKDIR}/pics/launcher/opie-background.jpg ${D}${palmtopdir}/pics/launcher/opie-background-240x320.jpg

#        for res in 320x240 240x320 320x320 320x480 480x320 480x640 640x480 600x800 800x600; do
        for res in 240x240 320x320 320x480 480x320 480x640 640x480 800x600; do
         install -m 0644 ${WORKDIR}/pics/launcher/firstuse-${res}.jpg ${D}${palmtopdir}/pics/launcher/firstuse-${res}.jpg
         install -m 0644 ${WORKDIR}/pics/launcher/opie-background-${res}.jpg ${D}${palmtopdir}/pics/launcher/opie-background-${res}.jpg
        done
}

python do_package_prepend () {
        reslist = ['240x320','320x240', '320x320', '320x480', '480x320', '480x640','640x480', '800x600','600x800']
        dir = bb.data.expand('${palmtopdir}/pics/launcher/', d)
        ft = bb.data.expand('${palmtopdir}/pics/*/*-%s.*', d)
        pn = bb.data.getVar('PN', d, 1)
        for res in reslist:
         bb.data.setVar('FILES_%s-%s' % (pn,res), ft % res, d )
         postinst = ''
         postinst = 'update-alternatives --install %sfirstuse.jpg opie-firstuse-pixmap %sfirstuse-%s.jpg 50\n' % (dir,dir,res)
         postinst += 'update-alternatives --install %sopie-background.jpg opie-background-pixmap %sopie-background-%s.jpg 50\n' % (dir,dir,res)
         bb.data.setVar('pkg_postinst_%s-%s' % (pn,res),postinst, d)
         prerm = ''
         prerm = 'update-alternatives --remove opie-firstuse-pixmap %sfirstuse-%s.jpg 50\n' % (dir,res)
         prerm += 'update-alternatives --remove opie-background-pixmap %sopie-background-%s.jpg 50\n' % (dir,res)
         bb.data.setVar('pkg_prerm_%s-%s' % (pn,res),prerm, d)
}

PACKAGE_ARCH = "all"
PACKAGES = "${PN}-dbg ${PN}-320x480 ${PN}-480x320 ${PN}-480x640 ${PN}-640x480 ${PN}-800x600 ${PN}-600x800 ${PN}-320x240 ${PN}-240x320 ${PN}-320x320"
RPROVIDES_${PN}-320x480 = "opie-taskbar-images"
RPROVIDES_${PN}-480x320 = "opie-taskbar-images"
RPROVIDES_${PN}-480x640 = "opie-taskbar-images"
RPROVIDES_${PN}-640x480 = "opie-taskbar-images"
RPROVIDES_${PN}-800x600 = "opie-taskbar-images"
RPROVIDES_${PN}-600x800 = "opie-taskbar-images"
RPROVIDES_${PN}-320x240 = "opie-taskbar-images"
RPROVIDES_${PN}-240x320 = "opie-taskbar-images"
RPROVIDES_${PN}-320x320 = "opie-taskbar-images"
