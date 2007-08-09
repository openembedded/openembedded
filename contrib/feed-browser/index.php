<?php

/*
 * (c) Koen Kooi 2006, 2007
 * (c) Marcin Juszkiewicz 2006, 2007
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

read_vars_from_get(array('name', 'arch', 'pkgsearch', 'letter', 'pkgname', 'section'));

$ipkgoutput = '';

if(!empty($section))
{
	$ipkgoutput = searchsection($section);
}
elseif(!empty($letter))
{
	$ipkgoutput = searchpkg("{$letter}%", $arch);
}
elseif(!empty($pkgname))
{
	$ipkgoutput = pkgdetails($pkgname);
}
elseif(!empty($pkgsearch) OR !empty($arch))
{
	$ipkgoutput = searchpkg("%{$pkgsearch}%", $arch);
}

$archs_list = get_arch_list();

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
					<input type="text" name="pkgsearch" value="<?php echo $pkgsearch; ?>" />
					<select name="arch">
					   <option value="" selected="selected">all architectures</option>
					   <option value="all">no arch</option>
<?php

foreach($archs_list as $architecture)
{
    echo "<option value='{$architecture['p_arch']}'";

    if($architecture['p_arch'] == $arch)
    {
	echo ' selected="selected"';
    }
    echo ">{$architecture['p_arch']}</option>";
}

?>
					</select>
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
