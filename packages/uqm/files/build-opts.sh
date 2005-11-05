#!/bin/sh
# Shamelessly stolen from gentoo ebuild
cat <<-EOF > config.state
CHOICE_debug_VALUE='nodebug'
CHOICE_graphics_VALUE='pure'
CHOICE_sound_VALUE='mixsdl'
INPUT_install_prefix_VALUE='$1'
INPUT_install_bindir_VALUE='$2'
INPUT_install_libdir_VALUE='$3'
EOF

# Take out the read so we can be non-interactive.
sed -i \
	-e '/read CHOICE/d' build/unix/menu_functions || \
	echo "sed menu_functions failed"
