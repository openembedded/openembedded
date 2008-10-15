DESCRIPTION = "Openmoko: Games for the Openmoko Linux Distribution"
SECTION = "openmoko/base"
LICENSE = "MIT"
FILE_PR = "r72"

inherit task

#
# task-openmoko-games
#
DESCRIPTION_task-openmoko-games = "Openmoko: Games"
RDEPENDS_task-openmoko-games = "\
  oh-puzzles \
  kobodeluxe \
"
