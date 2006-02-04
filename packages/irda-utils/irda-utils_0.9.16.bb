DESCRIPTION = "Provides common files needed to use IrDA. \
IrDA allows communication over Infrared with other devices \
such as phones and laptops."
SECTION = "base"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/irda/irda-utils-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://m4.patch;patch=1 \
	   file://init"

export SYS_INCLUDES="-I${STAGING_INCDIR}"

inherit autotools update-rc.d

INITSCRIPT_NAME = "irattach"
INITSCRIPT_PARAMS = "defaults 20"

do_compile () {
	oe_runmake -e -C irattach
	oe_runmake -e -C irdaping
}

do_install () {
	install -d ${D}${sbindir}
	oe_runmake -C irattach ROOT="${D}" install
	oe_runmake -C irdaping ROOT="${D}" install

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/irattach
}

pkg_postinst () {
#!/bin/sh

module_id() {
    awk 'BEGIN { FS=": " } /Hardware/ { print $2 } ' </proc/cpuinfo
 }

if [ ! -f /etc/sysconfig/irda ]; then

  case `module_id` in
    "HP iPAQ H2200" | "HP iPAQ HX4700")
	IRDA=yes
	DEVICE=/dev/tts/2
	DONGLE=
	DISCOVERY=
	;;
    *)
	IRDA=yes
	DEVICE=/dev/ttyS1
	DONGLE=
	DISCOVERY=
        ;;
  esac

  echo "IRDA=$IRDA" > /etc/sysconfig/irda
  if [ $IRDA = "yes" ]; then
    echo "DEVICE=$DEVICE" >> /etc/sysconfig/irda
    echo "DONGLE=$DONGLE" >> /etc/sysconfig/irda
    echo "DISCOVERY=$DISCOVERY" >> /etc/sysconfig/irda
  fi
fi
}
