DESCRIPTION = "Tasks for OPIE stuff"
SECTION = "opie/base"
LICENSE = "MIT"

inherit task

PACKAGES = "task-opie-apps task-opie-extra-apps"

RDEPENDS_task-opie-apps = "opie-advancedfm opie-bartender opie-calculator \
                  opie-checkbook opie-clock \
                  opie-console opie-dagger opie-embeddedkonsole \
                  opie-euroconv opie-eye opie-ftp opie-gutenbrowser \
                  opie-helpbrowser opie-irc opie-keypebble opie-odict \
                  opie-oxygen opie-rdesktop opie-reader opie-remote \
                  opie-sheet opie-tableviewer opie-tinykate \
                  opie-wellenreiter opie-write opie-zsafe"

#
# additional things for a >= 24mb distribution
#

RDEPENDS_task-opie-extra-apps = "opie-calculator opie-checkbook opie-mail opie-eye \
                        opie-rdesktop opie-wellenreiter opie-irc \
                        opie-mediaplayer2 \
                        qpdf2"
# konqueror-embedded
