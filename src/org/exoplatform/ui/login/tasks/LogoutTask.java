/*
 * Copyright (C) 2003-2014 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.ui.login.tasks;

import org.apache.http.client.HttpClient;

import android.os.AsyncTask;

/**
 * Created by The eXo Platform SAS
 * Author : Philippe Aristote
 *          paristote@exoplatform.com
 * May 12, 2014
 * 
 * Logout async task performs Logout action on a background thread
 *   
 */
public class LogoutTask extends AsyncTask<Void, Void, Void> {

  private HttpClient httpClient;
  
  /**
   * Calls getConnectionManager().shutdown() on the given HttpClient, in a background thread
   * @param _client the HttpClient to shutdown
   */
  public LogoutTask(HttpClient _client) {
    httpClient = _client;
  }
  
  @Override
  protected Void doInBackground(Void... params) {
    httpClient.getConnectionManager().shutdown();
    return null;
  }
  
  @Override
  protected void onPostExecute(Void result) {
    httpClient = null;
    super.onPostExecute(result);
  }
  

}
