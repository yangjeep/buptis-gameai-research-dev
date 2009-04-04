/*
 * deadend.ai.dog.monteCarloStateSingle.MCSimStrategy
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * deadend.ai.dog.monteCarloStateSingle.MCSimStrategy is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.dog.monteCarloStateSingle.MCSimStrategy is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog.monteCarloStateSingle;

import deadend.globalenum.Directions;
/**
 *
 * @author Yang JiaJian
 */
public abstract class MCSimStrategy {
    public abstract Directions nextDir(MSimGame game,java.awt.Point selfPos);
}
