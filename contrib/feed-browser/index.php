<?php

/*
 * (c) Koen Kooi 2006
 * (c) Marcin Juszkiewicz 2006
 *
 * This php script is intended to do the following:
 *
 * - have searchable webfronted for the feed like packages.ubuntu.com
 *
 * ToDo:
 *
 * - search functionality
 * - provide feed-management functionality
 * - allow uploading of new software
 *
 *
 * This program is free software; you can redistribute it and/or  modify it under
 * the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License.
 * 
 * This program is distributed in the hope that it will be useful,  but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public License along
 * with this library; see the file COPYING.LIB.  If not, write to the Free
 * Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307,
 * USA.
 *
 */

require_once 'includes/config.inc';
require_once 'includes/functions.inc';

if(!check_database())
{
	die("Database not found and cannot be created.");
}

$name = '';

if(isset($_GET['name']))
{
	$name = $_GET['name'];
}

$action = '';

if(isset($_GET['action']))
{
	$action = $_GET['action'];
}

if(isset($_GET['arch']))
{
	$arch = $_GET['arch'];
}


switch($action)
{
	case "details":
		$ipkgoutput = pkgdetails ($_GET['pnm']);
		break;

	case "search":
		if ( $arch == "" ) {
		    $ipkgoutput = searchpkg ("%{$name}%");
		    }
		else {
		    $ipkgoutput = searchpkgarch ("%{$name}%", "{$arch}");
		    }
		break;

	case "section":
		$ipkgoutput = searchsection($_GET['section']);
		break;

	case "letter":
		$letter = $_GET['g'];
		if ( $arch == "" ) {
		     $ipkgoutput = searchpkg ("{$letter}%");
		}
                else {
                    $ipkgoutput = searchpkgarch ("{$letter}%", "{$arch}");
                    }
                break;

	default:
		$ipkgoutput = searchpkg("a");
		break;
}

?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
    <head>
	<title>Feed browser</title>
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style type="text/css" media="all">@import "css/feed.css";</style>
    </head>
    <body >
		<div id="right">
			<?php echo searchletter(); ?>
			<form action="" method="get">
				<fieldset>
					<label for="name">Package name</label>
					<input type="text" name="name" value="<?php echo $name; ?>" />
					<select name="arch">
					   <option value="" selected="selected">all architectures</option>
					   <option value="all">noarch</option>
					   <option value="arm-oabi">arm OABI</option>
					   <option value="armv4t">armv4t EABI</option>
					   <option value="armv5te">armv5te EABI</option>
					   <option value="armv5teb">armv5teb EABI</option>
					   <option value="armv6">armv6 EABI</option>
					   <option value="avr32">avr32</option>
					   <option value="bfin">blackfin</option>
					   <option value="i486">i486</option>
					   <option value="i586">i586</option>
					   <option value="i686">i686</option>
					   <option value="iwmmxt">iwmmxt</option>
					   <option value="ppc603e">ppc603e</option>
					   <option value="sparc">sparc</option>
					</select>
					<input type="hidden" name="action" value="search" />
					<input type="submit" value="Search" />
				</fieldset>
			</form>
			<?php echo $ipkgoutput; ?>
		</div>
		<div id="left">
			<h1>Sections list</h1>
			<?php echo sectionslist(); ?>
		</div>
    </body>
</html>
