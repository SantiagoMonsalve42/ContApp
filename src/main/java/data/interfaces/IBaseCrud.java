/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.interfaces;

import java.util.List;

/**
 *
 * @author Santiago
 */
public interface IBaseCrud<T> {
    T create(T obj);
    T update(T obj);
    List<T> get();
    T get(int id);
    Boolean delete(int id);
}
