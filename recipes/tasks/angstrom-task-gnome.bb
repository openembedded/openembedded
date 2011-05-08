DESCRIPTION = "Task for a GNOME based image"

inherit task

# Most of these tasks are arch independant
PACKAGE_ARCH = "all"

XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-input-keyboard \
"

PR = "r16"

PACKAGES += "task-gnome-apps task-gnome-sdk task-gnome-fonts task-gnome task-gnome-gstreamer task-gnome-perl task-gnome-cups task-gnome-pulseaudio task-gnome-themes task-gnome-totem task-gnome-xserver-base task-gnome-xserver"

DEPENDS = "gst-plugins-ugly"

RDEPENDS_task-gnome-apps = " \
  abiword-meta \
  cheese \
  claws-mail \
  epiphany epiphany-extensions \
  swfdec swfdec-gnome swfdec-mozilla \
  eog \
  evince  evince-nautilus-extension \
#  firefox gecko-mediaplayer-firefox-hack \
  gcalctool \
  gedit gedit-plugins \
  gftp \
  gimp \
  gnome-games gnome-games-extra-data \
  gnome-mplayer \
  gnumeric \
  gphoto2 \
  gthumb \
  pidgin \
  synergy \
  vnc \
  x11vnc \
  xterm \
 "

RDEPENDS_task-gnome-sdk = " \
  cron cron-dev \
  geany \
  git \
  gtk+-dev \
  ldd \
  libltdl \
  libtool libtool-dev \
  pkgconfig \
  subversion \
  texinfo \
  task-native-sdk \
 "

RDEPENDS_task-gnome-fonts = " \
  font-adobe-75dpi \
  fontconfig fontconfig-utils font-util \
  ttf-arphic-uming \
  ttf-dejavu-common \
  ttf-dejavu-sans \
  ttf-dejavu-serif \
  ttf-dejavu-sans-mono \
  ttf-liberation-sans \
  ttf-liberation-serif \
  ttf-liberation-mono \
 "  

RDEPENDS_task-gnome = " \
  at-spi \
  cron \
  dconf \
  file-roller \
  gconf gconf-editor \
  gdm \
  gnome-control-center \
  gnome-applets \
  gnome-backgrounds \
  gnome-bluetooth \
  gnome-desktop \
  gnome-doc-utils \
  gnome-keyring gnome-keyring-pam-plugin libgnome-keyring libpam-meta pam-plugin-ck-connector \
  gnome-media \
  gnome-menus \
  gnome-mime-data \
  gnome-mount \
  gnome-nettool \
#  gnome-packagekit packagekit packagekit-gtkmodule \
  gnome-panel libpanel-applet libgweather-locationdata \
  gnome-power-manager gnome-power-manager-applets \
  gnome-python gnome-python-extras \
  gnome-python-desktop \
  gnome-screensaver \
  gnome-session \
  gnome-settings-daemon \
  gnome-system-monitor \
  gnome-system-tools system-tools-backends\
  gnome-terminal \
  gnome-utils \
  gnome-vfs \
  gnome-vfs-plugin-bzip2 \
  gnome-vfs-plugin-computer \
  gnome-vfs-plugin-dns-sd \
  gnome-vfs-plugin-file \
  gnome-vfs-plugin-ftp \
  gnome-vfs-plugin-gzip \
  gnome-vfs-plugin-http \
  gnome-vfs-plugin-network \
  gnome-vfs-plugin-nntp \
  gnome-vfs-plugin-sftp \
  gnome-vfs-plugin-tar \
  gsettings-desktop-schemas \
  gvfs \
  glib-2.0-utils \
  libgnome-bin \
  metacity \
  nautilus nautilus-cd-burner desktop-file-utils gnome-mount gamin \
  networkmanager network-manager-applet networkmanager-openvpn modemmanager \
  ntpdate \
  policykit-gnome policykit \
  zenity \
 "

DEPENDS_task-gnome-gstreamer = " \
  gst-plugins-base \
  gst-plugins-good \
  gst-plugins-bad \
  gst-plugins-ugly \
"

RDEPENDS_task-gnome-gstreamer = " \
  gst-ffmpeg \
  gst-plugin-pulse \
  gst-plugins-base-meta \
  gst-plugins-good-meta \
  gst-plugins-bad-meta \
  gst-plugins-ugly-meta \
"

RDEPENDS_task-gnome-perl = " \
  perl \
  task-perl-module-all \
  libnet-dbus-perl \
  libxml-parser-perl \
  libxml-twig-perl \
"

RDEPENDS_task-gnome-cups = " \
  cups cups-gs gs \
  cups-backend-hal \
  gnome-cups-manager \
  gtk-printbackend-cups \
  hal-cups-utils \
#  hplip hplip-ppd hplip-cups hplip-backend hplip-filter\
 "

RDEPENDS_task-gnome-pulseaudio = " \
  pulseaudio-alsa-wrapper \
  pulseaudio-esd-wrapper \
  pulseaudio-module-gconf \
  libasound-module-ctl-pulse \
  libasound-module-pcm-pulse \
 "

RDEPENDS_task-gnome-themes = " \
  angstrom-gnome-icon-theme-enable \
  gnome-icon-theme \
  gnome-themes \
  gnome-theme-crux \
  gnome-theme-highcontrast \
  gnome-theme-highcontrastinverse \
  gnome-theme-highcontrastlargeprint \
  gnome-theme-highcontrastlargeprintinverse \
  gnome-theme-largeprint \
  gnome-theme-mist \
  gtk-engine-clearlooks \
  gtk-engine-crux-engine \
  gtk-engine-glide \
  gtk-engine-hcengine \
  gtk-engine-thinice \
  gtk-engine-redmond95 \
  gtk-theme-clearlooks \
  gtk-theme-crux \
  gtk-theme-mist \
  gtk-theme-thinice \
  gtk-theme-redmond \
  hicolor-icon-theme \
  sound-theme-freedesktop \
 "

RDEPENDS_task-gnome-totem = " \
  totem \
  totem-browser-plugin \
  totem-plugin-bemused \
  totem-plugin-gromit \
  totem-plugin-media-player-keys \
  totem-plugin-ontop \
  totem-plugin-properties \
  totem-plugin-screensaver \
  totem-plugin-skipto \
  totem-plugin-thumbnail \
 "

RDEPENDS_task-gnome-xserver-base = " \
  dbus-x11 \
  desktop-file-utils \
  iso-codes \
  mime-support \
  notification-daemon inotify-tools \
  xauth \
  xdg-utils \
  xhost \
  xinetd \
  xinit \
  xlsfonts \
  xrandr \
  xrdb \
  xrefresh \
  xset \
  xvinfo \
 "

RDEPENDS_task-gnome-xserver = " \
  ${XSERVER} \
"

PACKAGE_ARCH_task-gnome-xserver = "${MACHINE_ARCH}"

RDEPENDS_${PN} = " \
  task-gnome-fonts \
  task-gnome \
  task-gnome-gstreamer \
  task-gnome-perl \
  task-gnome-cups \
  task-gnome-pulseaudio \
  task-gnome-themes \
  task-gnome-totem \
  task-gnome-xserver-base \
"

RRECOMMENDS_${PN} = " \
   task-gnome-xserver \
"

