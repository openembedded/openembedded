#!/bin/bash

DO_UCLIBC=0

do_build() {
	echo "MACHINE = \"$BUILD_MACHINE\"" > conf/auto.conf

	BUILD_MODE="glibc"
	if [ "$BUILD_CLEAN" != "" ]
	then
		bitbake -c clean $BUILD_CLEAN
	fi

	for target in $BUILD_TARGETS
	do
		bitbake $target && do_report_success
	done

	if [ $DO_UCLIBC = 1 ]
	then
		BUILD_MODE="uclibc"
		echo 'ANGSTROM_MODE = "uclibc"' >> conf/auto.conf
		for target in $BUILD_TARGETS
		do
			bitbake $target && do_report_success
		done
	fi
}

do_report_success() {

	echo "$(date -u +%s) $target $BUILD_MODE $machine" >> autobuilder-feed.log
}

for machine in ep93xx gumstix-connex gumstix-verdex efika omap5912osk ixp4xxle ixp4xxbe c7x0 poodle tosa akita spitz collie fic-gta01 a780 at91sam9263ek qemuarm h2200 h3900 h4000 poodle tosa hx4700 c7x0 spitz akita collie spitz 
do
        BUILD_MACHINE=$machine
	BUILD_CLEAN="libtool-cross qmake-native qmake2-native"
        BUILD_TARGETS="texinfo gcc binutils automake autoconf m4 pkgconfig \
	               task-proper-tools mc screen \
	               mono perl python ruby \
		       gtk+ qt-x11-free qt4-x11-free \
		       gpe-mini-browser midori minimo openmoko-browser2 webkit-gtklauncher \
		       samba \
		       apache2 boa cherokee lighttpd thttpd \
		       gpe-gallery gpe-scap notecase pidgin \
		       roadmap-gtk2 gpsdrive navit \
		       xmms mplayer quasar \
		       wpa-gui wifi-radar kismet \
		       gpe-bluetooth bluez-gnome python-pybluez \
		       abiword gnumeric evince epdfview gimp \
		       flite \
		       ctorrent \
		       gnuplot octave fftw fftwf fftwl \
		       gphoto2 gqview imagemagick ufraw \
		      "
	do_build
done

