DESCRIPTION = "OpenMoko: Games for the OpenMoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r71"

inherit task

#
# task-openmoko-games
#
DESCRIPTION_task-openmoko-games = "OpenMoko: Games"
RDEPENDS_task-openmoko-games = "\
  oh-puzzles \
"
