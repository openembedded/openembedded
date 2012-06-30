DESCRIPTION = "All packages required for the Jlime Muffinman userland"
LICENSE = "MIT"
PR = "r4"

inherit task

RDEPENDS_${PN} = "echinus ourico dzen2 matchbox-desktop net-tools xinit \
		  ttf-dejavu-sans xcursor-transparent-theme libxcursor \
		  alsa-utils-alsamixer alsa-utils-amixer xset xmodmap \
		  fnkey rxvt-unicode xdialog gtkedit gtk-engine-industrial \
		  gmu tzdata-africa tzdata-australia tzdata-antarctica \
		  tzdata-americas tzdata-arctic tzdata-atlantic tzdata-asia \
		  tzdata-europe tzdata-pacific tzdata wmctrl ttf-inconsolata \
		  fileselector feh imlib2-loaders mupdf stppc2x mplayer \
		  gcalc psplash jlime-extras greq midpath-backend-sdl \
		  midpath-core midpath-cldc libxmlpull-java netsurf-fb \
		  "
