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
                        ANGSTROMLIBC=uclibc MACHINE=$BUILD_MACHINE bitbake -c clean $BUILD_CLEAN
                fi
                
                for target in $BUILD_TARGETS
                do
                        ANGSTROMLIBC=uclibc MACHINE=$BUILD_MACHINE bitbake $target && do_report_success
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
# * armv5teb:  ixp4xxbe
# * armv6:     nokia800
# * armv6-novfp: htckaiser
# * armv7a:    beagleboard
# * ppc405:    dht-walnut
# * ppc603e:   efika
# * i586:      qemux86

if [ "$1" = "" ] ; then
	ARCH_MACHINES="simpad om-gta01 c7x0 ixp4xxbe nokia800 htckaiser beagleboard dht-walnut efika qemux86"
else
	ARCH_MACHINES="$@"
fi

for machine in ${ARCH_MACHINES}
do
        BUILD_MACHINE=$machine
        BUILD_CLEAN="opkg-native qmake-native qmake2-native qt-x11-free iso-codes perl perl-native python python-native python-pygtk gnome-icon-theme"
        BUILD_TARGETS=" \
                      opkg-native \
                      abiword \
                      aircrack-ng \
                      angstrom-task-gnome \
                      angstrom-zeroconf-audio \
                      apache2 \
                      artoolkit \
                      asciidoc \
                      asterisk \
                      atomic \
                      autoconf \
                      automake \
                      balsa \
                      binutils \
                      bison \
                      blueman \
                      bluez-gnome \
                      bluez-hcidump \
                      boa \
                      bonjour \
                      camera-assistant \
                      cdparanoia \
                      cdstatus \
                      checkers \
                      cherokee \
                      claws-mail \
                      connman \
                      connman-gnome \
                      contacts \
                      cpufrequtils \
                      cron \
                      cvs \
                      cwiid \
                      dates \
                      devicekit-disks \
                      devmem2 \
                      dialog \
                      distcc \
                      dsniff \
                      dosfstools \
                      duke3d \
                      dvb-apps \
                      dvbstream \
                      dvbtraffic \
                      dvbtune \
                      e-uae \
                      e-wm \
                      ekiga \
                      empathy \ 
                      emtooth \
                      enna \
                      eog \
                      epdfview \
                      epiphany \
                      evince \
                      exalt \
                      exalt-client \
                      exo \
                      fakeroot \
                      fennec \
                      flame \
                      fluxbox \
                      ffmpeg \
                      fftw \
                      fftwf \
                      fftwl \
                      findutils \
                      firefox \
                      fish \
                      fldigi \
                      flex \
                      flite \
                      frameworkd \
                      freenote \
                      froot \
                      frozen-bubble \
                      gcc \
                      gdal \
                      gdb \
                      gdbserver \
                      gdm \
                      geany \
                      geda \
                      geda-docs \
                      geda-examples \
                      geda-gattrib \
                      geda-gnetlist \
                      geda-gschem \
                      geda-gsymcheck \
                      geda-symbols \
                      geda-utils \
                      giac \
                      gimp \
                      glider \
                      gksu \
                      gmp \
                      gmpc \
                      gnome-dvb-daemon \
                      gnome-games \
                      gnome-mplayer \
                      gnome-panel \
                      gnome-system-monitor \
                      gnumeric \
                      gnuplot \
                      gnuradio \
                      gpe-bluetooth \
                      gpe-gallery \
                      gpe-login \
                      gpe-mini-browser \
                      gpe-mini-browser2 \
                      gpe-scap \
                      gpe-sketchbook \
                      git \
                      gperf \
                      gphoto2 \
                      gpsdrive \
                      gqview \
                      gsm0710muxd \
                      gspcav1 \
                      gst-omapfb \
                      gtk+ \
                      gzip \
                      hal \
                      hdparm \
                      hexatrolic \
                      htop \
                      i2c-tools \
                      iaimaster \
                      icebloxx \
                      imagemagick \
                      inkscape \
                      inkwp \
                      ioquake3 \
                      ipaq-sleep \
                      iperf \
                      iptables \
                      irssi \
                      iscsi-target \
                      ivman \
                      jamvm \
                      julius \
                      kernel-module-udlfb \
                      kismet \
                      konqueror-embedded \
                      labyrinth \
                      lcd4linux \
                      leafpad \
                      libv4l \
                      lighttpd \
                      links-x11 \
                      lirc \
                      lowpan-tools \
                      lyx \
                      m4 \
                      madplay \
                      mahjongg \
                      make \
                      maki \
                      mc \
                      mediatomb \
                      meta-nas-server \
                      meta-toolchain \
                      metacity \
                      midori \
                      mileage \
                      mono \
                      motion \
                      mousepad \
                      mpc \
                      mpd \
                      mpfr \
                      mpg123 \
                      mplayer \
                      mtd-utils \
                      mutt \
                      mysql5 \
                      mythtv \
                      mythplugins \
                      myththemes \
                      nano \
                      nautilus \
                      nbench-byte \
                      navit \
                      netbook-launcher-efl \
                      netkit-ftp \
                      netsurf \
                      news \
		      nfs-utils \
                      nmap \
                      nmm \
                      notecase \
                      ntfs-3g \
                      numptyphysics \
                      octave \
                      openbox \
                      opencv \
                      opencv-samples \
                      openmoko-browser2 \
                      openredalert \
                      openvpn \
                      opie-notes \
                      orage \
                      padevchooser \
                      pavucontrol \
                      palantir \
                      pairs \
                      paprefs \
                      pciutils \
                      pdamaze \
                      perl \
                      php \
                      pidgin \
                      pine \
                      pingus \
                      pipeman \
                      pkgconfig \
                      places \
                      pmount \
                      pngcrush \
                      pocketcellar \
                      povray \
                      prboom \
                      prelink \
                      proftpd \
                      pushover \
                      python \
                      python-pybluez \
                      python-coherence \
                      python-pygame \
                      qfish2 \
                      qmatrix \
                      qpe-nmap \
                      qt-x11-free \
                      qt4-x11-free \
                      quake2 \
                      quasar \
                      quetoo \
                      rain \
                      rdesktop \
                      read-edid \
                      resistorui \
                      roadmap-gtk2 \
                      rtorrent \
                      ruby \
                      samba \
                      screen \
                      scummvm \
                      sdlquake \
                      sdrshell \
                      sensors-applet \
                      setserial \
                      shisensho \
                      slcalc \
                      sliderulez \
                      sokoban \
                      squeakvm \
                      stalonetray \
                      strace \
                      subversion \
                      sugar \
                      sylpheed \
                      sysstat \
                      systray \
                      task-beagleboard-demo \
                      task-gpe-pim \
                      task-openmoko-feed \
                      task-openmoko-games \
                      task-opie-apps \
                      task-opie-games \
                      task-proper-tools \
                      task-xqtlauncher \
                      tasks \
                      texinfo \
                      tgt \
                      thttpd \
                      thunar \
                      tightvnc \
                      timesleuth \
                      tofrodos \
                      totem \
                      transmission \
                      tron \
                      tzdata \
                      ubahnnav \
                      ufraw \
                      unzip \
                      usbutils \
                      usbview \
                      ushare \
                      vdr \
                      viking \
                      vlc \
                      vpnc \
                      w3cam \
                      wifi-radar \
                      win4 \
                      wireshark \
                      wpa-gui \
                      wscan \
                      wt \
                      wt3 \
                      wvdial \
                      x11vnc \
                      xclip \
                      xf86-input-evdev \
                      xf86-input-evtouch \
                      xf86-input-keyboard \
                      xf86-input-mouse \
                      xf86-input-tslib \
                      xf86-video-ati \
                      xf86-video-displaylink \
                      xf86-video-fbdev \
                      xf86-video-sisusb \
                      xf86-video-vesa \
                      xfce-mcs-manager
                      xfce-mcs-manager \
                      xfce-mcs-plugins \
                      xfce-terminal \
                      xfce-utils \
                      xfce4-appfinder \
                      xfce4-dev-tools \
                      xfce4-icon-theme \
                      xfce4-mixer \
                      xfce4-panel \
                      xfce4-session \
                      xfdesktop \
                      xfprint \
                      xfwm4 \
                      xfwm4-themes \
                      xinput \
                      xinput-calibrator \
                      xmame \
                      xmms \
                      xrefresh \
                      xserver-kdrive \
                      xserver-xorg \
                      zauralign \
                      zddice \
                      zenity \
                      zgscore \
                      zhone \
                      zip \
                      ziq \
                      zlapspeed \
                      zrev7 \
                      zsubhunt \
                      ztappy \
                      zuc \
                      zudoku \
                      "
        do_build
done        

# machine packages (machine specific (sub)packages)

if [ "$1" = "" ] ; then
    MACHINES="simpad om-gta01 c7x0 ixp4xxbe nokia800 htckaiser beagleboard dht-walnut efika qemux86"
else
    MACHINES="$@"
fi

for machine in ${MACHINES}
do
        BUILD_MACHINE=$machine
            BUILD_CLEAN="qmake-native qmake2-native qt-x11-free python python-native python-pygtk gnome-icon-theme"
        BUILD_TARGETS="task-base task-boot \
                       task-opie task-opie-all \
                       task-openmoko-base task-openmoko-debug task-openmoko-examples task-openmoko-linux task-openmoko-native-sdk task-openmoko-net task-openmoko-phone task-openmoko-pim task-openmoko-ui \
                       angstrom-x11-base-depends angstrom-gpe-task-settings \
                       xserver-xorg-conf \ 
                       "

        do_build
done

for machine in collie h2200 hx4700 spitz akita tosa poodle c7x0
do
        BUILD_MACHINE=$machine
        BUILD_TARGETS="linux-kexecboot \
		       "
	do_build
done	
