DESCRIPTION = "Paroli"
SECTION = "x11"
LICENSE = "GPL"
PV = "0.2.1+gitr${SRCREV}"
PE = "1"
PR = "r0"

SRC_URI = "git://git.paroli-project.org/paroli.git;protocol=http;branch=shr"
S = "${WORKDIR}/git"

inherit distutils

PACKAGES += "${PN}-autostart ${PN}-theme ${PN}-sounds ${PN}-calculator"

RDEPENDS = "\
  python-datetime \
  python-subprocess \
  python-textutils \
  python-dbus \
  python-pygobject \
  python-elementary \
  dbus-x11 \
  task-fso-compliance \
  elementary \
  elementary-themes \
  edbus-ehal \
"

E_CONFIG_DIR="/usr/share/enlightenment/data"

RULES_YAML = rules.yaml
RULES_YAML_om-gta01 = gta01_rules.yaml

do_configure_append() {
	# fix absolute etc reference
	sed -i "s|/etc/|../../etc/|" ${S}/setup.py
	sed -i "s|prefix,|'../../usr/',|" ${S}/setup.py
	sed -i "s|core/|/usr/lib/python2.6/site-packages/|" ${S}/scripts/paroli
	sed -i "s|services|/usr/share/paroli/services|" ${S}/scripts/paroli.fso.cfg
	sed -i "s|applications|/usr/share/paroli/applications|" ${S}/scripts/paroli.fso.cfg
}

do_install_append() {
#	install ${D}${sysconfdir}/paroli/paroli.fso.cfg ${D}${sysconfdir}/paroli/paroli.cfg

       	# install paroli theme
       	install -d ${D}${E_CONFIG_DIR}/themes
       	install ${S}/data/e-config/paroli.edj ${D}${E_CONFIG_DIR}/themes/
       	install ${S}/data/e-config/serenity.edj ${D}${E_CONFIG_DIR}/themes/
       	install -d ${D}${E_CONFIG_DIR}/config/paroli
       	install ${S}/data/e-config/paroli/* ${D}${E_CONFIG_DIR}/config/paroli/
       	install -d ${D}${E_CONFIG_DIR}/config/paroli-serenity
       	install ${S}/data/e-config/paroli-serenity/* ${D}${E_CONFIG_DIR}/config/paroli-serenity/

	install -d ${D}${datadir}/elementary/themes
	install ${S}/data/paroli.edj ${D}${datadir}/elementary/themes

   	install -d ${D}${datadir}/icons
	install ${S}/data/paroli.png ${D}${datadir}/icons

   	install -d ${D}${datadir}/applications	
	install ${S}/data/paroli.desktop ${D}${datadir}/applications

       	# install autostart
    	install -d ${D}${E_CONFIG_DIR}/applications/all
	cp ${D}/usr/share/applications/paroli.desktop ${D}${E_CONFIG_DIR}/applications/all
    	install -d ${D}${E_CONFIG_DIR}/applications/startup
       	echo "${E_CONFIG_DIR}/applications/all/paroli.desktop" >> ${D}${E_CONFIG_DIR}/applications/startup/.order

#	install -d ${D}${sysconfdir}/freesmartphone/oevents
#	install ${S}/data/${RULES_YAML} ${D}${sysconfdir}/freesmartphone/oevents/paroli_rules.yaml
#	install ${S}/data/frameworkd.conf ${D}${sysconfdir}/paroli_frameworkd.conf

	install -d ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone
	install ${S}/data/default.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml

	install -d ${D}${datadir}/dbus-1/system-services/
	install ${S}/data/dbus/org.tichy.launcher.service ${D}${datadir}/dbus-1/system-services/

	install -d ${D}${datadir}/sounds
	install ${S}/data/sounds/* ${D}${datadir}/sounds

}

pkg_postinst_${PN}-autostart() {
#!/bin/sh
# do this off or on line
if [ "x$D" != "x" ]; then
	ROOTFS=${IMAGE_ROOTFS}
else
	ROOTFS=""
fi

# post installation script
if [ -x $ROOTFS${sysconfdir}/X11/Xsession.d/80zhone ]; then
   echo "*******************************************"
   echo "Deactivating zhone autostart"
   echo "*******************************************"
   chmod -x $ROOTFS${sysconfdir}/X11/Xsession.d/80zhone || true
fi
exit 0
}

#pkg_postinst_${PN}-sounds() {
#!/bin/sh
# do this off or on line
#if [ "x$D" != "x" ]; then
#	ROOTFS=${IMAGE_ROOTFS}
#else
#	ROOTFS=""
#fi
# post installation script
#if [ ! -e /$ROOTFS${sysconfdir}/freesmartphone/opreferences/conf/phone/old_default.yaml ] ; then
#    echo "Backing up ${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml"
#    mv $ROOTFS${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml $ROOTFS${sysconfdir}/freesmartphone/opreferences/conf/phone/old_default.yaml
#fi
#cp $ROOTFS${sysconfdir}/freesmartphone/opreferences/conf/phone/paroli_default.yaml $ROOTFS${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml
#exit 0
#}

pkg_postinst_${PN}-theme() {
#!/bin/sh
# do this off or on line
if [ "x$D" != "x" ]; then
	ROOTFS=${IMAGE_ROOTFS}
else
	ROOTFS=""
fi
# post installation script
echo 'E_PROFILE="-profile paroli"' > $ROOTFS${sysconfdir}/enlightenment/default_profile
exit 0
}

FILES_${PN} = " \
	${sysconfdir}/dbus-1 \
	${sysconfdir}/paroli \
	${sysconfdir}/freesmartphone/oevents \
	${prefix}/lib \
	${prefix}/bin \
	${datadir}/paroli/applications/common-for-edje \
	${datadir}/paroli/applications/inout \
	${datadir}/paroli/applications/telephony \
	${datadir}/paroli/applications/messages \
	${datadir}/paroli/applications/launcher \
	${datadir}/paroli/applications/people \
	${datadir}/paroli/applications/settings \
	${datadir}/applications \
	${datadir}/elementary \
	${datadir}/paroli/services \
	${datadir}/paroli/data \
	${datadir}/pixmaps \
	${datadir}/icons \
	${datadir}/dbus-1/system-services/ \
	"

FILES_${PN}-theme = " \
	${E_CONFIG_DIR}/themes \
	${E_CONFIG_DIR}/config \
	"

FILES_${PN}-autostart = "${E_CONFIG_DIR}/applications"

FILES_${PN}-sounds = " \
	${datadir}/sounds/ \
	${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml \
	"

FILES_${PN}-calculator = " \
	${datadir}/paroli/applications/calculator \
	"

CONFFILES_${PN} += " \
	${sysconfdir}/paroli/paroli.fallback.cfg \
	${sysconfdir}/paroli/paroli.pyneo.cfg \
	${sysconfdir}/paroli/paroli.fso.cfg \
	"
CONFFILES_${PN}-sounds += " \
	${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml \
	"
