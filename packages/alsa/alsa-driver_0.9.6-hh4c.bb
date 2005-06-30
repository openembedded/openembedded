DESCRIPTION = "Alsa Drivers"
MAINTAINER = "Pigi"
SECTION = "console/utils"
LICENSE = "GPL"
#DEPENDS = "alsa-lib"


SRC_URI = "ftp://ftp.handhelds.org/packages/alsa-driver/alsa-driver-${PV}.tar.gz \
	file://sound.p.patch;patch=1 \
	file://h5400.patch;patch=1 \
	file://adriver.h.patch;patch=1 "

#inherit autotools
#inherit module

#EXTRA_OECONF = "  --with-isapnp=no "
EXTRA_OECONF=" --with-sequencer=no --with-isapnp=no --with-oss=yes  --with-cards=${cards} --with-kernel=${STAGING_KERNEL_DIR} --with-kernel-version=${KERNEL_VERSION} --host=arm-linux"
#EXTRA_OECONF = " /ext/ambient/tmp/work/handhelds-sa-2.4.19-rmk6-pxa1-hh37.4-r5/kernel/ "


do_configure() {

VERS=`grep "^VERSION =" ${STAGING_KERNEL_DIR}/Makefile | awk '{print $3}'`
PATLEV=`grep "^PATCHLEVEL =" ${STAGING_KERNEL_DIR}/Makefile | awk '{print $3}'`
SBLEV=`grep "^SUBLEVEL =" ${STAGING_KERNEL_DIR}/Makefile | awk '{print $3}'`
EXVER=`grep "^EXTRAVERSION =" ${STAGING_KERNEL_DIR}/Makefile | awk '{print $3}'`

KERNEL_VERSION=$VERS.$PATLEV.$SBLEV$EXVER

cards=
if egrep "CONFIG_SA1100_H3[168]00=y" "${STAGING_KERNEL_DIR}/.config" ; then
  cards="$cards,sa11xx-uda1341"
  familiar_arch=ipaqsa
fi
if grep "CONFIG_ARCH_H3900=y" "${STAGING_KERNEL_DIR}/.config" ; then
  cards="$cards,pxa-uda1380,h5400-ak4535"
  familiar_arch=ipaqpxa
fi
cards="$cards,bluez-sco,pdaudiocf"

   configure ${EXTRA_OECONF}
   #./config.ipaq ${STAGING_KERNEL_DIR}

}



do_install() {

if egrep "CONFIG_SA1100_H3[168]00=y" "${STAGING_KERNEL_DIR}/.config" ; then
  familiar_arch=ipaqsa
fi
if grep "CONFIG_ARCH_H3900=y" "${STAGING_KERNEL_DIR}/.config" ; then
  familiar_arch=ipaqpxa
fi
extra_modules="snd-gus-synth.o snd-emu8000-synth.o snd-emux-synth.o \
        snd-ainstr-fm.o snd-ainstr-gf1.o snd-ainstr-iw.o snd-ainstr-simple.o \
        snd-seq-midi-emul.o snd-seq-midi-event.o snd-seq-midi.o snd-seq-virmidi.o snd-seq-oss.o"

      fakeroot make -k NODEPMOD=yes DESTDIR=${D} install; 

      for i in ${extra_modules}; 
        do rm -f ${D}/lib/modules/*/misc/$i; 
      done

      if [ -d ${D}/${sysconfdir}/modutils/ ] ; then 
         rm -r ${D}/${sysconfdir}/modutils/ ;
      fi
      mkdir ${D}/${sysconfdir}/modutils/
      cp familiar/alsa-modules-${familiar_arch} ${D}/${sysconfdir}/modutils/
}

#FILES_alsa-driver = "/lib/modules/${KERNEL_VERSION}/misc/snd* /${sysconfdir}/init.d/ /${sysconfdir}"
FILES_${PN} = "/lib/modules/*/misc/snd* ${sysconfdir}/modutils/* "

