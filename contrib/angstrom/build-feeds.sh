#!/bin/bash

# Split into "noarch" "arch" and "machine" section
# build "noarch" for only one machine, build "arch" *one* time for each arch and build "machine" for each machine

DO_UCLIBC=0

do_build() {
	#echo "MACHINE = \"$BUILD_MACHINE\"" > conf/auto.conf

	BUILD_MODE="glibc"
	if [ "$BUILD_CLEAN" != "" ]
	then
		MACHINE=$BUILD_MACHINE bitbake -c clean $BUILD_CLEAN
	fi

	for target in $BUILD_TARGETS
	do
		MACHINE=$BUILD_MACHINE bitbake $target && do_report_success
	done

	if [ $DO_UCLIBC = 1 ]
	then
		BUILD_MODE="uclibc"
		
		if [ "$BUILD_CLEAN" != "" ]
        	then
                	ANGSTROM_MODE=uclibc MACHINE=$BUILD_MACHINE bitbake -c clean $BUILD_CLEAN
        	fi
		
		for target in $BUILD_TARGETS
		do
			ANGSTROM_MODE=uclibc MACHINE=$BUILD_MACHINE bitbake $target && do_report_success
		done
	fi
}

do_report_success() {

	echo "$(date -u +%s) $target $BUILD_MODE $machine" >> autobuilder-feed.log
}

# noarch packages (e.g. PACKAGE_ARCH=all in OE)

BUILD_MACHINE="beagleboard"
BUILD_CLEAN=""
BUILD_TARGETS=""
do_build

# arch packages (no machine specific (sub)packages)

# Architectures:
# * arm-oabi:  simpad
# * armv4t:    om-gta01
# * armv5te:   c7x0
# * armv6:     nokia800
# * armv7a:    beagleboard
# * ppc405:    dht-walnut
# * ppc603e:   efika

for machine in simpad om-gta01 c7x0 nokia800 beagleboard dht-walnut efika
do
	BUILD_MACHINE=$machine
	BUILD_CLEAN="qmake-native qmake2-native qt-x11-free python"
	BUILD_TARGETS="texinfo flex bison gperf gcc binutils make automake autoconf m4 pkgconfig distcc \
	               gdb gdbserver strace \
		       usbutils pciutils mtd-utils usbview hal setserial \
		       task-proper-tools mc screen findutils fakeroot gzip \
		       mono jamvm perl python ruby \
                       gtk+ qt-x11-free qt4-x11-free \
                       gpe-mini-browser gpe-mini-browser2 netsurf midori firefox epiphany fennec minimo openmoko-browser2 \
                       samba meta-nas-server \
                       apache2 boa cherokee lighttpd thttpd \
                       gpe-sketchbook gpe-gallery gpe-scap notecase leafpad task-gpe-pim \
                       pidgin irssi \
                       roadmap-gtk2 gpsdrive navit viking \
                       ffmpeg xmms totem mplayer quasar vlc-gpe gnome-mplayer \
                       wpa-gui wifi-radar kismet aircrack-ng dsniff \
                       nmap iptables iperf openvpn vpnc \
                       gpe-login ipaq-sleep \
                       gpe-bluetooth bluez-gnome python-pybluez \
                       abiword gnumeric evince epdfview gimp \
                       scummvm \
                       flite \
                       ctorrent \
                       asterisk \
                       gnuradio gnuplot mpfr gmp fftw fftwf fftwl \
                       gphoto2 gqview imagemagick ufraw \
                       rdesktop x11vnc tightvnc \
                       tzdata \
                       xserver-kdrive xserver-xorg \
                       xf86-video-fbdev xf86-video-ati xf86-video-vesa \
                       xf86-input-evdev xf86-input-keyboard xf86-input-mouse \
                       task-opie-games task-opie-apps \
                       konqueror-embedded ubahnnav freenote inkwp opie-notes mileage pocketcellar timesleuth zgscore \
                       zlapspeed zuc zddice camera-assistant slcalc sliderulez resistorui qpe-nmap \
                       atomic checkers fish glider hexatrolic icebloxx labyrinth mahjongg maki nmm pairs pdamaze \
                       pipeman shisensho sokoban tron win4 zauralign ziq zrev7 zsubhunt ztappy zudoku iaimaster \
                       qmatrix qfish2 froot \
                       gsm0710muxd frameworkd zhone \
                       gnome-games \
                       mythtv \
                       ioquake3 quake2 quetoo sdlquake \
                       prboom openredalert \
                       e-wm \
                       angstrom-zeroconf-audio
                       task-openmoko-feed task-openmoko-games \
                       "
	do_build
done	

# machine packages (machine specific (sub)packages)

for machine in beagleboard efika dht-walnut omap5912osk ixp4xxle ixp4xxbe c7x0 poodle tosa akita spitz collie simpad om-gta01 om-gta02 a780 at91sam9263ek qemuarm h2200 h3900 h4000 hx4700 nokia800 
do
        BUILD_MACHINE=$machine
	BUILD_CLEAN=""
	BUILD_TARGETS="task-base task-boot \
                       task-opie task-opie-all \
		       task-openmoko-base task-openmoko-debug task-openmoko-examples task-openmoko-linux task-openmoko-native-sdk task-openmoko-net task-openmoko-phone task-openmoko-pim task-openmoko-ui \
                       angstrom-x11-base-depends angstrom-gpe-task-settings \
                       "
	do_build
done

